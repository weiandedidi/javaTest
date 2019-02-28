package guavaStu.list;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * list 转为map
 * 方法一：
 * (key1, key2) 元素
 * Map<Integer, Aoo> id2AooMap = aoos.stream().collect(Collectors.toMap(Aoo::getId, aoo -> aoo, (key1, key2) -> key2))
 * <p>
 * 方法二：
 * Map<Integer, Aoo> id2AooMapV2 = Maps.uniqueIndex(aoos, new Function<Aoo, Integer>() {}重写 apply方法
 *
 * @author qidi
 * @date 2018-12-29 15:12
 */
public class ListToMapTest {
    public static void main(String[] args) {
        List<Aoo> aoos = Lists.newArrayList(new Aoo(1, 10), new Aoo(2, 11), new Aoo(3, 12));
        // 方法一
        Map<Integer, Aoo> id2AooMap = aoos.stream().collect(Collectors.toMap(Aoo::getId, aoo -> aoo, (key1, key2) -> key2));
        System.out.println(id2AooMap);

        // 方法二：
        Map<Integer, Aoo> id2AooMapV2 = Maps.uniqueIndex(aoos, new Function<Aoo, Integer>() {
            @Override
            public Integer apply(Aoo aoo) {
                return aoo.getId();
            }
        });


        System.out.println(id2AooMapV2);

    }

    @Data
    @AllArgsConstructor
    private static class Aoo {
        private Integer id;
        private Integer age;
    }
}

