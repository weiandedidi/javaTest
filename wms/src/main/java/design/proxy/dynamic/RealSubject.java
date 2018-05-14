package design.proxy.dynamic;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/14
 * Time: 10:12
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("我是实现接口的实现类");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello i am class :" + str);
    }
}
