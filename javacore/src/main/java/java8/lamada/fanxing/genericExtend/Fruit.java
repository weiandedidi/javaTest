package java8.lamada.fanxing.genericExtend;

import lombok.Data;

/**
 * 水果类
 *
 * @author qidi
 * @date 2019-11-25 21:33
 */
@Data
public class Fruit {
    String name;
}

@Data
class Apple extends Fruit {
    private String color;
}
