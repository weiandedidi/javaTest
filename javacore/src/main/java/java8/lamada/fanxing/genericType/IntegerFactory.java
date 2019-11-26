package java8.lamada.fanxing.genericType;

/**
 * @author qidi
 * @date 2019-11-25 21:21
 */
public class IntegerFactory implements Factory<Integer> {
    @Override
    public Integer create() {
        Integer integer = new Integer(9);
        return integer;
    }
}
