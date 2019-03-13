package design.factory.xmlAbstractFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/10
 * Time: 9:48
 */
public class SpringSkinFactory implements SkinFactory {

    public Button createButton() {
        return new SpringButton();
    }

    public TextField createTextField() {
        return new SpringTextField();
    }

    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
