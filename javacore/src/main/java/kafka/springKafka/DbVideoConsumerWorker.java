package kafka.springKafka;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;
import kafka.springKafka.entry.DbVideo;
import kafka.springKafka.service.DbVideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/6/11
 * Time: 18:12
 */
public class DbVideoConsumerWorker implements Runnable {
    Logger logger = LoggerFactory.getLogger(DbVideoConsumerWorker.class);


    DbVideoService dbVideoService;

    private KafkaStream<String, String> stream;

    public DbVideoConsumerWorker(KafkaStream<String, String> stream) {
        this.stream = stream;
    }


    @Override
    public void run() {
        dbVideoService = (DbVideoService) DbVideoListener.applicationContext.getBean("dbVideoService");
        ConsumerIterator<String, String> it = stream.iterator();

        //一直持续
        while (it.hasNext()) {
            MessageAndMetadata<String, String> messageAndMetadata = it.next();
            logger.debug(Thread.currentThread().getName() + ": partition[" + messageAndMetadata.partition() + "],"
                    + "offset[" + messageAndMetadata.offset() + "], " + new String(messageAndMetadata.message()));

            String message = new String(messageAndMetadata.message());
            JSONObject object = JSONObject.parseObject(message);
            String operation = object.getString("operation");

            //判断是上架还是下架
            if (DbVideoConstant.ADD.equals(operation)) {
                //新增
                JSONArray jsonArray = object.getJSONArray("content");
                List<DbVideo> toInsetVideos = transJsonArray2Videos(jsonArray);
                if (toInsetVideos.size() < 1) {
                    continue;
                }
                //插入
                dbVideoService.batchInsertDbvideos(toInsetVideos);
                toInsetVideos = null;
            }
            if (DbVideoConstant.DELETE.equals(operation)) {
                //下架
                JSONArray jsonArray = object.getJSONArray("content");
                List<DbVideo> deleteVideos = new ArrayList<DbVideo>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject deleteData = jsonArray.getJSONObject(i);
                    Long videoId = deleteData.getLong("doc_id");
                    DbVideo dbVideo = new DbVideo();
                    dbVideo.setVideoId(videoId);
                    dbVideo.setStatus(DbVideoConstant.STATUS_DELETE);
                    dbVideo.setSourceId(DbVideoConstant.SOURCE_SOFA);
                    dbVideo.setCheckStatus(DbVideoConstant.CHECK_NO_PASS);
                    deleteVideos.add(dbVideo);
                }
                dbVideoService.batchDeleteDbvideosByVideoIds(deleteVideos);
                deleteVideos = null;
            }
        }
    }

    /**
     * 把消息转为dbvideo
     * {"source_name":"sohu_sofa","source_id":"f979bf87f8ce9061e690a8e73cccfb97","operation":"ADD","timestamp":"1528641175248","content":[{"vid":190592711703646208,"cid":22,"videoTitle":"报废的自行车千万别丢，看牛人如何将它改成电动车，真不愧是逆天神器","subtitle":"报废的自行车千万别丢，看牛人如何将它改成电动车，真不愧是逆天神器","description":"报废的自行车千万别丢，看牛人如何将它改成电动车，真不愧是逆天神器","videoDuration":330800,"videoUploadTime":1528599980825,"thumbnailUrl":"http://img01.youju.sohu.com/e992bdf0-e3ac-4505-a1bb-e3a8c674739a.jpg","verticalThumbnailUrl":"","authorName":"机械创造者","userId":7443,"avatarUrl":"http://img01.youju.sohu.com/20180104230405_5538e54c.jpg","videoTag":"千万别,如何,牛人,逆天,自行车","videoStatus":1,"code":0,"playInfo":[{"playId":190593290613243904,"videoLevelId":2,"videoWidth":852,"videoHeight":480,"videoSize":26612828,"videoUrl":"http://video01.youju.sohu.com/c511ac5e-583a-4e20-a9f8-4a64bec7883e2_1_0.mp4","videoStatus":3,"isX265":false,"rate":"606508"}],"site":"sohutv","oriPlayCount":0,"oriCommentCount":0,"category":"1023"}]}
     *
     * @param jsonArray 沙发kafka消息
     * @return
     */
    private List<DbVideo> transJsonArray2Videos(JSONArray jsonArray) {
        Random random = new Random();
        //黑名单 易车和汽车视频
        Set<DbVideo> dbVideos = new HashSet<DbVideo>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            DbVideo dbVideo = new DbVideo();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //疑似色情，直接不保存
            Integer isPorn = jsonObject.getInteger("code");
            if (DbVideoConstant.IS_PORN.equals(isPorn)) {
                continue;
            }
            Long videoId = jsonObject.getLong("vid");
            dbVideo.setVideoId(videoId);
            String name = jsonObject.getString("videoTitle");
            dbVideo.setName(name);
            String description = jsonObject.getString("description");
            dbVideo.setDescription(description);
            Long duration = jsonObject.getLong("videoDuration");
            dbVideo.setDuration(duration);
            String thumbnailUrl = jsonObject.getString("thumbnailUrl");
            dbVideo.setThumbnailUrl(thumbnailUrl);
            String author = jsonObject.getString("authorName");
            dbVideo.setAuthor(author);
            Long playCount = jsonObject.getLong("oriPlayCount");
            playCount = playCount < 1000 ? (1000 + random.nextInt(1000)) : playCount;   //避免播放量少
            dbVideo.setPlayCount(playCount);
            Long commentCount = jsonObject.getLong("oriCommentCount");
            dbVideo.setCommentCount(commentCount);
            String videoSite = jsonObject.getString("site");
            dbVideo.setVideoSite(videoSite);
            Integer sourceId = DbVideoConstant.SOURCE_SOFA; //沙发视频
            dbVideo.setSourceId(sourceId);
            //遍历循环playinfo的内容
            JSONArray playInfos = jsonObject.getJSONArray("playInfo");
            int minIndex = 0;
            int tempCompare = 10;
            Integer videoLevelId;
            //取清晰度最低的
            for (int j = 0; j < playInfos.size(); j++) {
                JSONObject playInfo = playInfos.getJSONObject(j);
                videoLevelId = playInfo.getInteger("videoLevelId");
                if (videoLevelId <= tempCompare) {
                    tempCompare = videoLevelId;
                    minIndex = j;
                }
            }
            JSONObject playInfo = playInfos.getJSONObject(minIndex);
            videoLevelId = playInfo.getInteger("videoLevelId");
            dbVideo.setVideoLevelId(videoLevelId);
            String rate = playInfo.getString("rate");
            dbVideo.setRate(rate);
            Timestamp createdTime = new Timestamp(System.currentTimeMillis());
            dbVideo.setCreatedTime(createdTime);
            Long playId = playInfo.getLong("playId");
            dbVideo.setPlayId(playId);
            String videoUrl = playInfo.getString("videoUrl");
            dbVideo.setVideoUrl(videoUrl);
            Integer videoHeight = playInfo.getInteger("videoHeight");
            dbVideo.setVideoHeight(videoHeight);
            Integer videoWidth = playInfo.getInteger("videoWidth");
            dbVideo.setVideoWidth(videoWidth);
            Integer isx265 = playInfo.getBoolean("isX265") ? 1 : 0; //1是 0不是
            dbVideo.setIsx265(isx265);
            //写入默认值
            dbVideo.setFileId("");
            dbVideo.setStatus(DbVideoConstant.STATUS_UN_PUB);
            dbVideo.setCheckStatus(DbVideoConstant.CHECK_UNDO);
            dbVideo.setChannelCode(0L);
            dbVideo.setTagRelationId(0L);
            dbVideo.setPropertyCode(0L);
            dbVideo.setModelId(0L);
            dbVideo.setFirstCategoryCode(0L);
            dbVideo.setSecondCategoryCode(0L);
            dbVideo.setThirdCategoryCode(0L);
            dbVideos.add(dbVideo);
        }
        List<DbVideo> dbVideoList = null;
        if (dbVideos.size() < 1) {
            dbVideoList = new ArrayList<DbVideo>();
            return dbVideoList;
        }
        dbVideoList = new ArrayList<DbVideo>(dbVideos);
        return dbVideoList;
    }

    public static void main(String[] args) {
/*        String message = "{\"source_name\":\"sohu_sofa\",\"source_id\":\"f979bf87f8ce9061e690a8e73cccfb97\",\"operation\":\"ADD\",\"timestamp\":\"1528641175248\",\"content\":[{\"vid\":190592711703646208,\"cid\":22,\"videoTitle\":\"报废的自行车千万别丢，看牛人如何将它改成电动车，真不愧是逆天神器\",\"subtitle\":\"报废的自行车千万别丢，看牛人如何将它改成电动车，真不愧是逆天神器\",\"description\":\"报废的自行车千万别丢，看牛人如何将它改成电动车，真不愧是逆天神器\",\"videoDuration\":330800,\"videoUploadTime\":1528599980825,\"thumbnailUrl\":\"http://img01.youju.sohu.com/e992bdf0-e3ac-4505-a1bb-e3a8c674739a.jpg\",\"verticalThumbnailUrl\":\"\",\"authorName\":\"机械创造者\",\"userId\":7443,\"avatarUrl\":\"http://img01.youju.sohu.com/20180104230405_5538e54c.jpg\",\"videoTag\":\"千万别,如何,牛人,逆天,自行车\",\"videoStatus\":1,\"code\":0,\"playInfo\":[{\"playId\":190593290613243904,\"videoLevelId\":2,\"videoWidth\":852,\"videoHeight\":480,\"videoSize\":26612828,\"videoUrl\":\"http://video01.youju.sohu.com/c511ac5e-583a-4e20-a9f8-4a64bec7883e2_1_0.mp4\",\"videoStatus\":3,\"isX265\":false,\"rate\":\"606508\"}],\"site\":\"sohutv\",\"oriPlayCount\":0,\"oriCommentCount\":0,\"category\":\"1023\"}]}";
        JSONObject object = JSONObject.parseObject(message);
        String operation = (String) object.get("operation");
        JSONArray jsonArray = object.getJSONArray("content");
        List<DbVideo> toInsetVideos = transJsonArray2Videos(jsonArray);
        System.out.println(toInsetVideos.get(0).getName());*/


/*        String message = "{\"source_name\":\"sohu_sofa\",\"source_id\":\"f979bf87f8ce9061e690a8e73cccfb97\",\"operation\":\"DELETE\",\"timestamp\":\"1524017221283\",\"content\":[{\"doc_url\":\"\",\"doc_id\":\"171197461612482560\",\"reason\":\"\"}]}";
        JSONObject object = JSONObject.parseObject(message);
        JSONArray jsonArray = object.getJSONArray("content");
        List<DbVideo> deleteVideos = new ArrayList<DbVideo>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject deleteData = jsonArray.getJSONObject(i);
            Long videoId = deleteData.getLong("doc_id");
            DbVideo dbVideo = new DbVideo();
            dbVideo.setVideoId(videoId);
            dbVideo.setStatus(DbVideoConstant.STATUS_DELETE);
            deleteVideos.add(dbVideo);
        }
        System.out.println(deleteVideos.get(0).getVideoId());
        System.out.println(deleteVideos.get(0).getStatus());*/
    }


}
