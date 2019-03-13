package design.factory.xmlAbstractFactory;

/**
 * 皮肤工厂，可生产按钮、图层、盒子
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/9
 * Time: 17:49
 */
public interface SkinFactory {
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}
