package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author qidi
 * @date 2019-11-15 15:55
 */
public class JSONObjectTest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "wo");
        jsonObject.put("name", "ni");
        System.out.println(JSON.toJSONString(jsonObject));
    }
}
