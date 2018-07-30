package kafka.springKafka.service;


import kafka.springKafka.dao.DbVideoDao;
import kafka.springKafka.entry.DbVideo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 车型库视频服务
 *
 * @author: qidima
 * @date: 2018/5/18
 * Time: 19:09
 */
@Service("dbVideoService")
@Transactional(readOnly = true)
public class DbVideoService {

    @Resource(name = "dbVideoDao")
    DbVideoDao dbVideoDao;


    /**
     * 通过视频id查找 视频
     *
     * @param id
     * @return
     */
    public DbVideo getVideoById(Integer id) {
        return dbVideoDao.getDbVideoById(id);
    }


    public List<DbVideo> getDbVideoList(Map<String, Object> params) {
        return dbVideoDao.getDbVideoList(params);
    }

    /**
     * 通过id作为参数查找list
     *
     * @param params
     * @return
     */
    public List<DbVideo> getDbVideoListById(Map<String, Object> params) {
        return dbVideoDao.getDbVideoListById(params);
    }

    @Transactional(readOnly = false)
    public void batchInsertDbvideos(List<DbVideo> dbVideos) {
        dbVideoDao.batchInsertDbvideos(dbVideos);
    }

    @Transactional(readOnly = false)
    public void batchUpateDbvideos(List<DbVideo> dbVideos) {
        dbVideoDao.batchUpateDbvideos(dbVideos);
    }

    @Transactional(readOnly = false)
    public void batchDeleteDbvideosByVideoIds(List<DbVideo> dbVideos) {
        dbVideoDao.batchDeleteDbvideosByVideoIds(dbVideos);
    }


    public Integer insertDbVideo(DbVideo video) {
        return dbVideoDao.insert(video);
    }

    @Transactional(readOnly = false)
    public void updateDbVideo(DbVideo video) {
        dbVideoDao.update(video);
    }

}
