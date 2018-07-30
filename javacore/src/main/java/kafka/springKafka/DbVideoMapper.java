package kafka.springKafka;

import kafka.springKafka.entry.DbVideo;

import java.util.List;
import java.util.Map;

public interface DbVideoMapper {

    Integer insert(DbVideo dbVideo);

    void update(DbVideo dbVideo);

    DbVideo getDbVideoById(Integer id);

    Integer countDbVideo(Map<String, Object> params);

    List<DbVideo> getDbVideoList(Map<String, Object> params);

    List<DbVideo> getDbVideoListById(Map<String, Object> params);

    void batchUpateDbvideos(List<DbVideo> dbVideos);

    void batchDeleteDbvideosByVideoIds(List<DbVideo> dbVideos);

    void batchInsertDbvideos(List<DbVideo> dbVideos);


}