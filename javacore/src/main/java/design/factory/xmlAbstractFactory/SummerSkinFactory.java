package design.factory.xmlAbstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/10
 * Time: 9:50
 */
public class SummerSkinFactory implements SkinFactory {
    public Button createButton() {
        return new SummerButton();
    }

    public TextField createTextField() {
        return new SummerTextField();
    }

    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
