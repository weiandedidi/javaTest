package design.factory.xmlAbstractFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/9
 * Time: 17:54
 */
public class SpringTextField implements TextField {
    public void display() {
        System.out.println("显示绿色边框");
    }
}
