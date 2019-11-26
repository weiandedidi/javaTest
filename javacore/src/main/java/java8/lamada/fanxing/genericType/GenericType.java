package java8.lamada.fanxing.genericType;

import lombok.Data;

/**
 * @author qidi
 * @date 2019-11-25 21:07
 */
public class GenericType<T> {
    Class<?> classType;

    /**
     * 入参构造
     *
     * @param type
     */
    public GenericType(Class<?> type) {
        classType = type;
    }

    public boolean isInstance(Object object) {
        return classType.isInstance(object);
    }

    public static void main(String[] args) {
        GenericType<A> genericType = new GenericType<>(A.class);
        System.out.println("------------");
        System.out.println(genericType.isInstance(new A()));
        System.out.println(genericType.isInstance(new B()));

    }

    @Data
    static class A {
        private String name;
    }

    @Data
    static class B {
        private String name;
    }
}
