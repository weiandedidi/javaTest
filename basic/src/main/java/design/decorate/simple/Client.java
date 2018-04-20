package design.decorate.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 17:03
 */
public class Client {
    public static void main(String[] args) {
        Component component, componentSB;  //使用抽象构件定义
        component = new Window(); //定义具体构件
        componentSB = new ScrollBarDecorator(component); //定义装饰后的构件
        componentSB.display();
    }
}
