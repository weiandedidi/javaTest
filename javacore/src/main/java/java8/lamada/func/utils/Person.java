package java8.lamada.func.utils;

import lombok.Data;

/**
 * 人类实体类
 *
 * @author qidi
 * @date 2019-11-26 19:46
 */
@Data
public abstract class Person {
    String name;
    Integer age;


    /**
     * 展示其count
     */
    public abstract int showCount();
}
