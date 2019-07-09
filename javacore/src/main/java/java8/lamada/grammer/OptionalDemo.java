package java8.lamada.grammer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Optional 主要用于返回值类型
 * 如：
 * 返回值为空时，默认一个值
 * <p>
 * stream().findFirst()返回的是第一个元素是Optional的
 *
 * @author qidi
 * @date 2019-02-25 16:58
 */
public class OptionalDemo {
    public static void main(String[] args) {
        List<Integer> ids = Lists.newArrayList();
        //存在返回1，不存在返回orElse的值
        Integer id = ids.stream().findFirst().orElse(0);
        System.out.println(id);
    }

}
