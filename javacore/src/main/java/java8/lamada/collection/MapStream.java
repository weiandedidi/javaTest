package java8.lamada.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2019-07-05 10:33
 */
public class MapStream {


    public static void main(String[] args) {
        Map<Integer, Aoo> id2AooMap = new HashMap<>();

        List<Aoo> aooList = Lists.newArrayList(
                new Aoo(1, "a"),
                new Aoo(2, "b"),
                new Aoo(3, "c")

        );

        id2AooMap = converToMap(aooList);

        System.out.println(id2AooMap);

    }

    private static Map<Integer, Aoo> converToMap(List<Aoo> aooList) {
        Map<Integer, Aoo> id2AooMap = Maps.newHashMap();
        if (CollectionUtils.isNotEmpty(aooList)) {
            Map<Integer, Aoo> id2AooM = aooList.stream().collect(Collectors.toMap(Aoo::getId, a -> a, (k1, k2) -> k1));
            id2AooMap.putAll(id2AooM);
        }
        return id2AooMap;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Aoo {

        private Integer id;
        private String name;
    }
}
