package guavaStu.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 不可变集合学习
 * 作为常量使用比较合适，因为里面的参数不会变，不可以添加元素
 * 详见 https://github.com/google/guava/wiki/ImmutableCollectionsExplained
 * <p>
 * 场景
 * 1. 当对象被不可信的库调用时，不可变形式是安全的；
 * 2. 不可变对象被多个线程调用时，不存在竞态条件问题
 * 3. 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
 * 4. 不可变对象因为有固定不变，可以作为常量来安全使用。
 *
 * <p>
 * ImmutableXXX 创建方式有三种
 * 1. copyOf   ImmutableSet.copyOf(set)
 * 2. of       ImmutableSet.of("a", "b", "c")
 * 3. Builder
 *
 * @author qidi
 * @date 2019-07-10 14:45
 */
public class ImmutableDemo {
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");

    public static void main(String[] args) {
        //1. copyOf
        ImmutableList<Integer> ids = ImmutableList.copyOf(Lists.newArrayList(1, 2, 3));
        //2. of
        ImmutableList<String> names = ImmutableList.of("a", "b", "c");
        //3. builder
        List<String> temp = Lists.newArrayList("a", "b", "c");
        ImmutableList<String> nameList = ImmutableList
                .<String>builder()
                .addAll(temp)
                .build();
    }
}
