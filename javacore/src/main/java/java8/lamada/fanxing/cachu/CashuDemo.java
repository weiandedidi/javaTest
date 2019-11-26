package java8.lamada.fanxing.cachu;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Map;

/**
 * 泛型擦除
 * <p>
 * 擦除后的类型是原数据类型
 *
 * @author qidi
 * @date 2019-11-25 19:57
 */
public class CashuDemo {
    public static void main(String[] args) {
        Class<?> class1 = new ArrayList<String>().getClass();
        Class<?> class2 = new ArrayList<Integer>().getClass();

        System.out.println(class1);        //class java.util.ArrayList
        System.out.println(class2);        //class java.util.ArrayList
        System.out.println(class1.equals(class2));    //true
        Map<String, String> map = Maps.newHashMap();
        System.out.println(map.getClass().getTypeParameters());
    }
}
