package java8.lamada.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 循环测试
 *
 * @author qidi
 * @date 2019-08-26 10:36
 */
public class LoopForEachTest {
    public static void main(String[] args) {
        List<Integer> ids = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            ids.add(i);
        }

        ids.forEach(id -> {
            if (id > 5) {
                return;
            }
            System.out.println(id);
        });

    }
}
