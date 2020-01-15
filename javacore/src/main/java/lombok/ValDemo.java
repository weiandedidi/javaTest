package lombok;

import java.util.HashMap;

/**
 * val 泛型处理
 *
 * @author qidi
 * @date 2020-01-14 17:34
 */
public class ValDemo {
    public static void main(String[] args) {
        val map = new HashMap<Integer, String>();
        map.put(1, "你好");
        System.out.println(map.get(1));
    }
}
