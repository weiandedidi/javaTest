package design.prototype.advanced.shade;

/**
 * 周榜文档的附件对象
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/19
 * Time: 11:36
 */
public class Attachment {
    private  String name; //附件名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download(){
        System.out.println("下载附件，文件名字 "+ name);
    }
}
