package java8.lamada.fanxing.genericType;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 显示工厂
 *
 * @author qidi
 * @date 2019-11-25 21:23
 */
public class Test {
    public static void main(String[] args) {
        Creater<Integer> creater = new Creater<>();
        System.out.println(creater.newInstance(new IntegerFactory()));
        List<Integer> list = Lists.newArrayList();
    }
}
