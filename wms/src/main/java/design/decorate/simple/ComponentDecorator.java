package design.decorate.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 16:50
 */
public class ComponentDecorator extends Component{
    private Component component;  //维持对抽象构件类型对象的引用

    public ComponentDecorator(Component component)  //注入抽象构件类型的对象
    {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
