package lamada.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author qidi
 * @date 2019-03-11 17:55
 */
public class ContainsAllTest {
    public static void main(String[] args) {
        List<Integer> ids = Lists.newArrayList(1, 1, 2, 3);
        List<Integer> id2 = Lists.newArrayList(1, 2, 3);
        System.out.println(id2.containsAll(ids));
        System.out.println(ids.containsAll(id2));
    }
}
