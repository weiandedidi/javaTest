package java8.lamada.fanxing.genericType;

/**
 * @author qidi
 * @date 2019-11-25 21:18
 */
public class Creater<T> {
    T instance;

    /**
     * @param f   入参定义
     * @param <F> 返回值定义
     * @return
     */
    public <F extends Factory<T>> T newInstance(F f) {
        instance = f.create();
        return instance;
    }
}
