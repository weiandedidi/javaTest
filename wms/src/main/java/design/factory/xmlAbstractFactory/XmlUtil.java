package design.factory.xmlAbstractFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import design.factory.xmlAbstractFactory.SpringSkinFactory;

import java.io.File;
import java.io.IOException;

/**
 * 操作xml的工具类，方便用户配置
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/10
 * Time: 9:51
 */
public class XmlUtil {
    public static Object getBean() {
        //创建文档对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //获取dom对象
            Document document = builder.parse(new File("C:\\Users\\qidima\\IdeaProjects\\ma\\wms\\src\\main\\java\\design\\factory\\xmlAbstractFactory\\config.xml"));
            //获取节点
            NodeList nodeList = document.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            String className = node.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            return obj;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //最后的返回
        return null;
    }
}
