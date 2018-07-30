package kafka.springKafka.entry;


import java.io.Serializable;
import java.sql.Timestamp;

public class DbVideo implements Serializable {

    /**
     * 主键id，自增非空
     */
    private Integer id;
    /**
     * 播放id，是videoid的子集
     */
    private Long playId;
    /**
     * 沙发视频的视频id
     */
    private Long videoId;
    /**
     * 云生成视频id
     */
    private String fileId;
    /**
     * 视频名称
     */
    private String name;
    /**
     * 视频实际地址
     */
    private String videoUrl;
    /**
     * 视频高度
     */
    private Integer videoHeight;
    /**
     * 视频宽度
     */
    private Integer videoWidth;
    /**
     * 视频缩列图链接
     */
    private String thumbnailUrl;
    /**
     * 审核状态0-未审核 1-已审核
     */
    private Integer checkStatus;
    /**
     * 栏目
     */
    private Long channelCode;
    /**
     * 视频的标签关系表id
     */
    private Long tagRelationId;
    /**
     * 时长（单位：秒）
     */
    private Long duration;
    /**
     * 是否265 编码 0-否 1-是
     */
    private Integer isx265;
    /**
     * 视频性质（100000000：车型，200000000：非车型，默认0）
     */
    private Long propertyCode;
    /**
     * 视频作者
     */
    private String author;
    /**
     * 播放量
     */
    private Long playCount;
    /**
     * 评论量
     */
    private Long commentCount;
    /**
     * 简介
     */
    private String description;
    /**
     * 视频抓取的网站
     */
    private String videoSite;
    /**
     * 视频来源 1-搜狐汽车 2- 沙发视频
     */
    private Integer sourceId;
    /**
     * 视频状态（0：新建未发布，1：已发布，2：删除。默认0）
     */
    private Integer status;
    /**
     * 视频码率 单位b/s
     */
    private String rate;
    /**
     * 视频清晰度 0 极速，1，标清，2 高清 3 超清
     */
    private Integer videoLevelId;
    /**
     * 关联车型（默认0，表示没有关联车型）
     */
    private Long modelId;
    /**
     * 一级分类
     */
    private Long firstCategoryCode;
    /**
     * 二级分类
     */
    private Long secondCategoryCode;
    /**
     * 三级分类
     */
    private Long thirdCategoryCode;
    /**
     * 创建时间
     */
    private Timestamp createdTime;
    /**
     * 操作时间
     */
    private Timestamp operatortimeC;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPlayId() {
        return this.playId;
    }

    public void setPlayId(Long playId) {
        this.playId = playId;
    }

    public Long getVideoId() {
        return this.videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getVideoHeight() {
        return this.videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public Integer getVideoWidth() {
        return this.videoWidth;
    }

    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getCheckStatus() {
        return this.checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Long getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(Long channelCode) {
        this.channelCode = channelCode;
    }

    public Long getTagRelationId() {
        return this.tagRelationId;
    }

    public void setTagRelationId(Long tagRelationId) {
        this.tagRelationId = tagRelationId;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getIsx265() {
        return this.isx265;
    }

    public void setIsx265(Integer isx265) {
        this.isx265 = isx265;
    }

    public Long getPropertyCode() {
        return this.propertyCode;
    }

    public void setPropertyCode(Long propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPlayCount() {
        return this.playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public Long getCommentCount() {
        return this.commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoSite() {
        return this.videoSite;
    }

    public void setVideoSite(String videoSite) {
        this.videoSite = videoSite;
    }

    public Integer getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getVideoLevelId() {
        return this.videoLevelId;
    }

    public void setVideoLevelId(Integer videoLevelId) {
        this.videoLevelId = videoLevelId;
    }

    public Long getModelId() {
        return this.modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getFirstCategoryCode() {
        return this.firstCategoryCode;
    }

    public void setFirstCategoryCode(Long firstCategoryCode) {
        this.firstCategoryCode = firstCategoryCode;
    }

    public Long getSecondCategoryCode() {
        return this.secondCategoryCode;
    }

    public void setSecondCategoryCode(Long secondCategoryCode) {
        this.secondCategoryCode = secondCategoryCode;
    }

    public Long getThirdCategoryCode() {
        return this.thirdCategoryCode;
    }

    public void setThirdCategoryCode(Long thirdCategoryCode) {
        this.thirdCategoryCode = thirdCategoryCode;
    }

    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getOperatortimeC() {
        return this.operatortimeC;
    }

    public void setOperatortimeC(Timestamp operatortimeC) {
        this.operatortimeC = operatortimeC;
    }


}
