package java8.lamada.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试lamda是否是拷贝
 *
 * @author qidi
 * @date 2019-12-06 18:07
 */
public class ListCopyTest {

    public static void main(String[] args) {
        List<Aoo> list = Lists.newArrayList(new Aoo(1), new Aoo(2), new Aoo(3), new Aoo(4));
        List<Aoo> sub = list.stream().filter(item -> item.getAge() > 2).collect(Collectors.toList());


        System.out.println(list);
        System.out.println(sub);


        Aoo filter = list.stream().filter(o -> o.getAge() > 10).findAny().orElse(null);
        System.out.println(filter);
    }

    @AllArgsConstructor
    @Data
    static class Aoo {
        private Integer age;
    }
}
