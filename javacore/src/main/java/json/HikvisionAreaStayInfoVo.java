package json;

/**
 * 海康威视区间相机，http请求封装的实体类
 * User: qidi
 * Date: 2018/9/18
 * Time: 下午5:33
 */
public class HikvisionAreaStayInfoVo {
    /**
     * Ipv4
     */
    private String ipAddress;
    /**
     * Ipv6
     */
    private String ipv6Address;
    /**
     * 设备通信端口
     */
    private Integer portNo;
    /**
     * 设备 MAC 地址
     */
    private String macAddress;

    /**
     * 通道id
     */
    private String channelID;
    /**
     * 通道名称(监控点名称)
     */
    private String channelName;
    /**
     * 事件触发次数
     */
    private Integer activePostCount;
    /**
     * 时间类型
     */
    private String eventType;

    /**
     * 针对持续性事件
     * active – 表示有效事件; inactive – 表示无效事件;
     * <p>
     * 该字段的扩展意义在于，针对 持续性事件判断，以移动侦测 为例，当发生移动侦测(同一目 标)，事件会持续上传，在事件 结束后会上报一个 inactive 的 类型;
     */
    private String eventState;

    /**
     * 时间描述
     * 事件英文描述
     * cityManagement
     */
    private String eventDescription;

    /**
     * 设备id
     */
    private String deviceID;

    private PersonQueueRealTimeData personQueueRealTimeDate;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpv6Address() {
        return ipv6Address;
    }

    public void setIpv6Address(String ipv6Address) {
        this.ipv6Address = ipv6Address;
    }

    public Integer getPortNo() {
        return portNo;
    }

    public void setPortNo(Integer portNo) {
        this.portNo = portNo;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getActivePostCount() {
        return activePostCount;
    }

    public void setActivePostCount(Integer activePostCount) {
        this.activePostCount = activePostCount;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public PersonQueueRealTimeData getPersonQueueRealTimeDate() {
        return personQueueRealTimeDate;
    }

    public void setPersonQueueRealTimeDate(PersonQueueRealTimeData personQueueRealTimeDate) {
        this.personQueueRealTimeDate = personQueueRealTimeDate;
    }
}
