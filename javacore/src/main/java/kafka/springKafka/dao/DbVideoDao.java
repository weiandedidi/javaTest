package kafka.springKafka.dao;

import kafka.springKafka.entry.DbVideo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("dbVideoDao")
public class DbVideoDao {

	@Resource
	DbVideoMapper dbVideoMapper;

	public Integer insert(DbVideo dbVideo){
		return dbVideoMapper.insert(dbVideo);
	}
	
	public void update(DbVideo dbVideo) {
		dbVideoMapper.update(dbVideo);
	}
	
	public	DbVideo getDbVideoById(Integer id) {
		return dbVideoMapper.getDbVideoById(id);
	}

    public Integer countDbVideo(Map<String, Object> params) {
		return dbVideoMapper.countDbVideo(params);
	}

    public List<DbVideo> getDbVideoList(Map<String, Object> params) {
		return dbVideoMapper.getDbVideoList(params);
	}

	/**
	 * 通过id条件查找list
	 * @param params
	 * @return
	 */
	public List<DbVideo> getDbVideoListById(Map<String, Object> params) {
		return dbVideoMapper.getDbVideoListById(params);
	}

	public void batchInsertDbvideos(List<DbVideo> dbVideos){
		dbVideoMapper.batchInsertDbvideos(dbVideos);
	}

	public void batchUpateDbvideos(List<DbVideo> dbVideos) {
		dbVideoMapper.batchUpateDbvideos(dbVideos);
	}

	public void batchDeleteDbvideosByVideoIds(List<DbVideo> dbVideos) {
		dbVideoMapper.batchDeleteDbvideosByVideoIds(dbVideos);
	}




	
}