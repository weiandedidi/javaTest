package java8.lamada.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2019-08-26 20:30
 */
public class MapStreamTest {
    public static void main(String[] args) {
        Map<Integer, Object> map = Maps.newHashMap();
        map.put(1, "2");
//        Map<Integer, Object> map = Maps.newHashMap();

        List<Integer> ids = Lists.newArrayList(1, 2);

        Map<Integer, Object> objectMap = ids.stream().collect(Collectors.toMap(a -> a, a -> map.get(a), (k1, k2) -> k1));


    }
}
