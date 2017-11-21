package design.decorate.simple;

/**
 * 滚动条装饰类：具体装饰类
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 16:59
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    public  void setScrollBar()
    {
        System.out.println("为构件增加滚动条！");
    }

    public void display()
    {
        this.setScrollBar();
        super.display();
    }
}
