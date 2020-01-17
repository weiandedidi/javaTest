package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author qidi
 * @date 2020-01-16 17:14
 */
public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {

        //按照出现次数分成小堆
        HashMap<Integer, Integer> num2CountMap = new HashMap();
        for (int n : nums) {
            num2CountMap.put(n, num2CountMap.getOrDefault(n, 0) + 1);
        }

        //构建堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> num2CountMap.get(n1) - num2CountMap.get(n2));

        //堆中找k个元素
        for (int n : num2CountMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //输出结果
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        return result;
    }

}
