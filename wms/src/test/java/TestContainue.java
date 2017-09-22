import java.util.HashMap;
import java.util.Map;

/**
 * Created by qidima on 2017/7/6.
 */
public class TestContainue {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Integer> subMap = new HashMap<String, Integer>();
        map.put("a", subMap.put("aa", 5));
        map.put("b", 7);

        if (null != map.get("a")) {
            Map<String, Integer> temp = (Map<String, Integer>) map.get("a");
            if (null == temp.get("bb")) {

            }
            {
                System.out.println("a");
                System.out.println("b");
                System.out.println("c");
            }
        } else if (true) {

        }
    }
}
