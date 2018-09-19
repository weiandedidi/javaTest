package json;

import com.alibaba.fastjson.JSON;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/9/19
 * Time: 下午2:18
 */
public class TestHi {
    public static void main(String[] args) {
        String xxx = "{\n" +
                "  \"ipAddress\": \"103369119\",\n" +
                "  \"portNo\": 8000,\n" +
                "  \"protocol\": \"SDK\",\n" +
                "  \"macAddress\": \"94:e1:ac:87:35:75\",\n" +
                "  \"channelID\": 1,\n" +
                "  \"dateTime\": \"2018-07-31T11:31:15+08:00\",\n" +
                "  \"activePostCount\": 1,\n" +
                "  \"eventType\": \"personQueueRealTimeData\",\n" +
                "  \"eventState\": \"active\",\n" +
                "  \"eventDescription\": \"Person Queue Real Time Data\",\n" +
                "  \"channelName\": \"\",\n" +
                "  \"deviceID\": \"C19428612\",\n" +
                "  \"personQueueRealTimeDate\": {\n" +
                "    \"targetID\": 53,\n" +
                "    \"ruleID\": 1,\n" +
                "    \"ruleName\": \"\",\n" +
                "    \"personState\": \"enter\",\n" +
                "    \"enterTime\": \"2018-07-31T11:31:15+08:00\",\n" +
                "    \"leaveTime\": \"2018-07-31T11:31:15+08:00\",\n" +
                "    \"waitTime\": 0,\n" +
                "    \"peopleNum\": 3\n" +
                "  }\n" +
                "}";

        HikvisionAreaStayInfoVo hikvisionAreaStayInfoVo = JSON.parseObject(xxx, HikvisionAreaStayInfoVo.class);
        System.out.println(hikvisionAreaStayInfoVo.getPersonQueueRealTimeDate().getEnterTime());
    }
}
