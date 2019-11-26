package java8.lamada.fanxing.defclass;

/**
 * @author qidi
 * @date 2019-11-25 19:29
 */
public class GenericDemoInterImpl1 implements GenericDemoInter<String> {
    @Override
    public String next() {
        return "我是String的继承";
    }
}
