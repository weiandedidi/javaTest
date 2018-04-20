package design.bridge.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专为本操作写的xml工具类
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/20
 * Time: 11:25
 */
public class XMLUtil {
    /**
     * 将xml配置文件转化成map形式
     *
     * @param path 配置文件位置
     * @return map
     */
    public static Map<String, Object> getConfByXml(String path) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //创建SAXReader类的对象来实现读取XML文档
        SAXReader reader = new SAXReader();
        File file = new File(path);
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Element> images = root.elements("image");
        List<Element> oss = root.elements("os");
        Map<String, Object> map = new HashMap<String, Object>(5);
        String image = images.get(0).getText();
        String os = oss.get(0).getText();
        Object imageBean = Class.forName(image).newInstance();
        Object osBean = Class.forName(os).newInstance();
        map.put("image", imageBean);
        map.put("os", osBean);
        return map;
    }

}
