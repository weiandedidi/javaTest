package design.prototype.advanced.deepClone.bySerialization;

import java.io.Serializable;

/**
 * 周榜文档的附件对象
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/19
 * Time: 11:36
 */
public class Attachment implements Serializable{
    private  String name; //附件名
    public  void setName(String name)
    {
        this.name  = name;
    }
    public  String getName()
    {
        return  this.name;
    }
    public void download()
    {
        System.out.println("下载附件，文件名为" + name);
    }
}
