package design.decorate.more;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 10:33
 */
public class Client {
    public static void main(String[] args) {
        Component componentA, componentB, componentC;
        componentA = new Xoo();
        //使用装饰类装饰 第一次
        componentB = new FooDecorate(componentA);

        //第二次装饰
        componentC = new AooDecorate(componentB);

        componentC.show();


    }
}
