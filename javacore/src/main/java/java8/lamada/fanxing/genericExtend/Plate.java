package java8.lamada.fanxing.genericExtend;

/**
 * 盘子泛型
 *
 * @author qidi
 * @date 2019-11-25 21:40
 */
public class Plate<T> {
    T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }
}
