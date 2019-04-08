package json;

import com.alibaba.fastjson.JSON;

/**
 * @author qidi
 * @date 2019-04-03 19:26
 */
public class Parse {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"type\": 1,\n" +
                "  \"message\": 2,\n" +
                "  \"request_id\": 3,\n" +
                "  \"statusCode\": 4,\n" +
                "  \"version\": 5,\n" +
                "  \"model\": 6\n" +
                "}";

        Head head = JSON.parseObject(json, Head.class);
        System.out.println(head.getRequestId());
    }

}
