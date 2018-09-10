import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/30
 * Time: 下午4:35
 */
public class Stringxxx {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(25540);
        for (int i = 0; i < 25535; i++) {
            map.put(i, i);
        }
        String data = JSON.toJSONString(map);
        System.out.println(data);
    }
}
