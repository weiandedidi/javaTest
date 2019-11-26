package java8.lamada.fanxing.genericType;

/**
 * 显示泛型工厂
 *
 * @author qidi
 * @date 2019-11-25 21:17
 */
public interface Factory<T> {
    /**
     * 产品构建方法
     *
     * @return
     */
    T create();
}
