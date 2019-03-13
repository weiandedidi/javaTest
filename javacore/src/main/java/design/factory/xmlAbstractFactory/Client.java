package design.factory.xmlAbstractFactory;

import util.XmlUtilOne;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/10
 * Time: 9:51
 */
public class Client {
    public static void main(String[] args) {
        //使用抽象层定义
        SkinFactory factory;
        Button bt;
        TextField tf;
        ComboBox cb;
        factory = (SkinFactory) XmlUtilOne.getBeanByFilePath("D:\\work\\javaTest\\wms\\src\\main\\java\\design\\factory\\xmlAbstractFactory\\config.xml");
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createComboBox();
        bt.display();
        tf.display();
        cb.display();
    }
}
