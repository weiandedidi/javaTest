import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2019-08-20 19:59
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<Aoo> aooList = Lists.newArrayList(
                new Aoo("1", 2, 3),
                new Aoo("2", 2, 2),
                new Aoo("3", 2, 1)
        );

        List<Aoo> filterList = aooList.stream().filter(aoo -> aoo.getMoney() > aoo.getTotal()).collect(Collectors.toList());
        System.out.println(filterList);
    }

    @Data
    @AllArgsConstructor
    static
    class Aoo {
        private String name;
        private Integer money;
        private Integer total;
    }
}
