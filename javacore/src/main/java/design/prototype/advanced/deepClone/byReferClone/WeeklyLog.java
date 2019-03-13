package design.prototype.advanced.deepClone.byReferClone;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/19
 * Time: 14:31
 */
public class WeeklyLog implements Cloneable {
    private  Attachment attachment;
    private  String name;
    private  String date;
    private  String content;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

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
