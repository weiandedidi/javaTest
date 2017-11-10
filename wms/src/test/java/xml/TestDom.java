package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 读文件用SAXReader 写xml用
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/10
 * Time: 16:46
 */
public class TestDom {

    public Document getDomByPath(String path) throws DocumentException {
        //创建SAXReader类的对象来实现读取XML文档
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(path));
        return doc;
    }

    /**
     * 获取根元素
     *
     * @param document
     * @return
     */
    public Element readRoot(Document document) {
        return document.getRootElement();
    }

    /**
     * 获取根元素下所有节点
     *
     * @param root
     * @return
     */
    public List<Element> getAllChildsByRoot(Element root) {
        List<Element> list = root.elements();
        return list;
    }

    /**
     * 获取当前元素下指定名字的元素
     * @param element
     * @param targetName
     * @return
     */
    public List<Element> getElementsByName(Element element, String targetName) {
        List<Element> targets = element.elements(targetName);
        return targets;
    }

    /**
     * 获取指定元素下的所有元素
     * @param element
     * @return
     */
    public List<Element> elements(Element element){
        List<Element> elements = element.elements();
        return elements;
    }

    public static void main(String[] args) {
        String path = "D:\\work\\javaTest\\wms\\src\\test\\java\\xml\\employee.xml";

    }


}
