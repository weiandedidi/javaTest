package java8.lamada.func;

import java.util.function.Supplier;

/**
 * 用于构造
 *
 * @author qidi
 * @date 2019-11-22 19:36
 */
public class SupplierDemo {

    public static String demo(String a) {
        Supplier<String> supplier = () -> a + "5";
        return supplier.get();
    }

    public static void main(String[] args) {
        System.out.println(demo("2"));
    }
}
