import com.google.common.collect.Lists;

import java.util.List;

/**
 * 计算list方法
 *
 * @author qidi
 * @date 2019-10-15 12:58
 */
public class ListCall {

    public static void main(String[] args) {
        List<Integer> list_1 = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> list_2 = Lists.newArrayList(3, 4, 5);
        list_1.addAll(list_2);
        System.out.println(list_1);

        list_1.removeAll(list_2);
        System.out.println(list_1);
        System.out.println(list_2);

    }
}
