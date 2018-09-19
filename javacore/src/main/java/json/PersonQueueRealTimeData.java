package json;

/**
 * 海康停留相机承载个人 停留info的实体类
 * User: qidi
 * Date: 2018/9/19
 * Time: 上午11:33
 */
public class PersonQueueRealTimeData {
    /**
     * 目标id
     */
    private Integer targetID;
    /**
     * 规则id
     */
    private Integer ruleID;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 目标状态，进入区域，离开区域
     * enter
     * leave
     */
    private String personState;
    /**
     * 进入时间 格林威治时间
     */
    private String enterTime;
    /**
     * 离开时间 格林威治时间
     */
    private String leaveTime;
    /**
     * 停留时间
     */
    private Integer waitTime;
    /**
     * 区域人数
     */
    private Integer peopleNum;

    public Integer getTargetID() {
        return targetID;
    }

    public void setTargetID(Integer targetID) {
        this.targetID = targetID;
    }

    public Integer getRuleID() {
        return ruleID;
    }

    public void setRuleID(Integer ruleID) {
        this.ruleID = ruleID;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getPersonState() {
        return personState;
    }

    public void setPersonState(String personState) {
        this.personState = personState;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }
}
