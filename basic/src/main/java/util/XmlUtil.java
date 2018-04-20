package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * xml tools
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:37
 */
public class XmlUtil {

    /**
     * Document元素
     */
    Document doc;

    /**
     * 根元素
     */
    Element root;

    /**
     * XML文件路径
     */
    String path;

    /**
     * 验证例外
     */
    Element validateErrors = null;

    /**
     * 构造器
     *
     * @param filePath 构造内容
     * @param isFile  改内容是否来自于文件
     */
    XmlUtil(String filePath, boolean isFile) throws DocumentException {
        if (isFile) {
            SAXReader reader = new SAXReader();
            FileInputStream inputStream;
            try {
                inputStream = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new DocumentException("取得文件 : " + filePath + " InputStream例外 例外信息 : " + e.getMessage(), e);
            }
            this.doc = reader.read(inputStream);
            path = filePath;
        } else {
            doc = DocumentHelper.parseText(filePath);
            path = null;
        }
        root = doc.getRootElement();
    }

    //读的方法

    //写的方法


}
