package design.prototype.advanced.deepClone.byReferClone;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/19
 * Time: 14:28
 */
public class Attachment implements Cloneable {
    private String name;    //附件名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attachment clone(){
        try {
            Object object = super.clone();
            return (Attachment) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("不能克隆");
            return null;
        }
    }
}
