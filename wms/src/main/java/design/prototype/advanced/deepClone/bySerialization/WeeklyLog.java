package design.prototype.advanced.deepClone.bySerialization;

import java.io.*;

/**
 * 使用序列化实现深度克隆，利用了java的序列化功能
 * 1. 原型实现序列化
 * 2. 原型的应用对象实现序列化
 * 3. 重写clone方法 使用流 因为在序列化的过程中 对象已不再是原有的对象了
 *
 * 明显的spring的entry对象必须实现Serializable接口，使用的是深度clone
 * 这样做的前提是对象以及对象内部所有引用到的对象都是可串行化的，否则，就需要仔细考察那些不可串行化的对象可否设成transient，从而将之排除在复制过程之外。
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/19
 * Time: 11:49
 */
public class WeeklyLog implements Serializable {
    private String name;
    private String date;
    private String content;
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
//使用序列化技术实现深克隆
    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //对象流
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }
}
