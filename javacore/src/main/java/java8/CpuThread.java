package java8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author qidi
 * @date 2020-03-17 18:16
 */
public class CpuThread {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors() * 30);

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        List<List<Integer>> groupList = Lists.partition(intList, 10);
        System.out.println(groupList);
    }
}
