package design.decorate.simple;

/**
 * 文本框类：具体构件类
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 16:47
 */
public class TextBox extends Component {
    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}
