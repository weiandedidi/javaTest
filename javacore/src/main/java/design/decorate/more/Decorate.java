package design.decorate.more;

/**
 * 装饰类
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 10:29
 */
public abstract class Decorate implements Component{
    Component component;

    public Decorate(Component component) {
        this.component = component;
    }

    @Override
    public void show() {
        component.show();
    }
}
