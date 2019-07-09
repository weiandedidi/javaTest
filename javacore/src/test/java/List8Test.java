import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2019-05-30 21:26
 */
public class List8Test {
    public static void main(String[] args) {
        List<Aoo> aoos = Lists.newArrayList(
                new Aoo(1, "你1"),
                new Aoo(1, "你2"),
                new Aoo(2, "你3"),
                new Aoo(2, "你4"),
                new Aoo(3, "你5")
        );

//        Set<Integer> ids = aoos.stream().map(Aoo::getId).collect(Collectors.toSet());
//
//        System.out.println(ids);

        List<Aoo> aoosV1 = aoos.stream().filter(one -> one.getId() == 1).collect(Collectors.toList());
        System.out.println(aoosV1);
    }

    @Data
    @AllArgsConstructor
    static class Aoo {
        private Integer id;
        private String name;
    }
}
