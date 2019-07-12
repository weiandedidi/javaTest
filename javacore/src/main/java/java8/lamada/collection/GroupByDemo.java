package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java 8 groupby 分组 使用collect() 和Collectors.groupingBy(类::方法) 嵌套使用
 * <p>
 * <p>
 * Map<Integer, List<类>> map =list.stream().collect(Collectors.groupingBy(类::getId))
 *
 * @author qidi
 * @date 2019-01-17 19:13
 */
public class GroupByDemo {
    public static void main(String[] args) {
        List<Aoo> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            int d = i % 2;
            list.add(new Aoo(d, "name" + i, i));
        }
        Collectors.groupingBy(Aoo::getId);
        System.out.println(list);
        Map<Integer, List<Aoo>> map = list.stream().collect(Collectors.groupingBy(Aoo::getId));
        System.out.println(map);

        List<Integer> ids = list.stream().map(Aoo::getId).collect(Collectors.toList());
        System.out.println(ids);

        //groupBy 并加和
        Map<Integer, Integer> countMap = list.stream().collect(Collectors.groupingBy(Aoo::getId, Collectors.summingInt(a -> a.getCount())));
        System.out.println(countMap);

    }

    @Data
    @AllArgsConstructor
    static class Aoo {
        private int id;
        private String name;
        private int count;
    }

}
