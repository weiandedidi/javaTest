import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qidi
 * @date 2019-04-24 11:59
 */
public class MapTest {

    public static void main(String[] args) {
        Aoo aoo = new Aoo(new HashMap<Integer, String>() {
            {
                put(1, "1");
                put(2, "2");
                put(3, "3");
            }
        });

        Map<Integer, String> map = aoo.getMap();
        map.remove(2);
        map.put(4, "4");

        System.out.println(aoo.getMap().get(4));
    }

    @Data
    @AllArgsConstructor
    public static class Aoo {
        private Map<Integer, String> map;
    }
}
