package design.decorate.simple;

/**
 * 黑色边框装饰类：具体装饰类
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 17:02
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }
}
