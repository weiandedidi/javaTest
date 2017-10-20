package design.prototype.appDemo;

import java.io.File;
import java.util.Hashtable;
import java.util.List;

/**
 * 文件管理类    单例模式 饿汉
 * 通过hashtable存储各种document模版类，完成克隆
 * <p>
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/20
 * Time: 18:36
 */
class DocumentHandle {
    private Hashtable hashtable = new Hashtable();

    private static DocumentHandle handle = new DocumentHandle();

    //读取配置 塞入hashtable中
    private DocumentHandle() {
        List<DocumentTemplet> templetList = (List<DocumentTemplet>) XmlUtil.getBeanByFilePath("C:\\Users\\qidima\\IdeaProjects\\ma\\wms\\src\\main\\java\\design\\prototype\\appDemo\\config.xml");
//        List<DocumentTemplet> templetList = (List<DocumentTemplet>) XmlUtil.getBeanByFilePath("design/prototype/appDemo/config.xml");     linux
        for (DocumentTemplet templet : templetList) {
            hashtable.put(templet.getClass().getName(), templet);
        }
    }

    //增加新的公文对象
    public void addOfficialDocument(String  key,DocumentTemplet doc)
    {
        hashtable.put(key,doc);
    }
//  获取公文对象
    public DocumentTemplet getTempletByName(String DocumentName){
        DocumentTemplet prototype = (DocumentTemplet) hashtable.get(DocumentName);
        return prototype.clone();
    }


    public static DocumentHandle getHandle(){
        return handle;
    }


}
