package design.bridge.example;

import org.dom4j.DocumentException;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:29
 */
public class Client {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        AbstractImage image;
        ImageImpl imp;
        Map<String, Object> confMap = XMLUtil.getConfByXml("D:\\work\\javaTest\\wms\\src\\main\\java\\design\\bridge\\example\\demo.xml");
        image = (AbstractImage) confMap.get("image");
        imp = (ImageImpl) confMap.get("os");
        image.setImageImpl(imp);
        image.parseFile("小龙女");
    }
}
