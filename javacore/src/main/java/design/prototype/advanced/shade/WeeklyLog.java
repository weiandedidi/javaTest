package design.prototype.advanced.shade;

/**
 * 浅克隆，克隆对象中的基本属性（基本类型）实现克隆
 * 属性中的应用对象，克隆引用的地址，对象还是一个
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/19
 * Time: 11:39
 */
public class WeeklyLog implements Cloneable{
    private String name;
    private  String date;
    private  String content;
    private Attachment attachment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public WeeklyLog clone(){
        try {
            Object object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("不能克隆");
            return null;
        }
    }
}
