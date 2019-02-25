package lamada.collection;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * 集合方法
 * :: 直接访问Class的静态方法 关键字来访问类的构造方法，对象方法，静态方法。
 * <p>
 * User: qidi
 * Date: 2018/12/14
 * Time: 下午9:23
 */
@Data
public class CollectionDemo {
    private String name;

    private static void print(Integer number) {
        System.out.println(number);
    }

    public static void main(String[] args) {


        CovertStrToInteger covert = (param) -> Integer.valueOf(param);

        //guava的包
        List<String> players = Lists.newArrayList();
        List<Integer> numbers = Lists.newArrayList();
        players.add("1");
        players.add("2");
        players.add("3");
        players.add("4");
        //这个方法是转化的方法
        players.forEach(player -> {
            Integer number = covert.covertStrToInteger(player);
            numbers.add(number);
        });
        //打印的方法
        numbers.forEach(number -> print(number));
        //打印的方法  双:: 直接访问Class的静态方法
        numbers.forEach(CollectionDemo::print);


    }

    private interface CovertStrToInteger {
        Integer covertStrToInteger(String number);
    }

    public void hi() {
    }


}
