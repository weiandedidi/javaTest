package design.prototype.simple;

import java.util.Date;

/**
 * 以周报的例子进行展开
 * 需求：每周的内容相似
 * 创立周报原型，其他的周报复制周报模版 在此基础上修改
 * 可实现java的clone的接口，调用clone()方法，实现父类全属性的复制
 * <p>
 * 2．Java的clone()方法
 * ⑴clone方法将对象复制了一份并返回给调用者。一般而言，clone（）方法满足：
 * ①对任何的对象x，都有x.clone() !=x//克隆对象与原对象不是同一个对象
 * ②对任何的对象x，都有x.clone().getClass()= =x.getClass()//克隆对象与原对象的类型一样
 * ③如果对象x的equals()方法定义恰当，那么x.clone().equals(x)应该成立。
 * <p>
 * ⑵Java中对象的克隆
 * ①为了获取对象的一份拷贝，我们可以利用Object类的clone()方法。
 * ②在派生类中覆盖基类的clone()方法，并声明为public。
 * ③在派生类的clone()方法中，调用super.clone()。
 * ④在派生类中实现Cloneable接口。
 * <p>
 * 注意
 * ①为什么我们在派生类中覆盖Object的clone()方法时，一定要调用super.clone()呢？在运行时刻，Object中的clone()识别出你要复制的是哪一个对象，然后为此对象分配空间，并进行对象的复制，将原始对象的内容一一复制到新对象的存储空间中。
 * ②继承自java.lang.Object类的clone()方法是浅复制。以下代码可以证明之。
 * <p>
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/19
 * Time: 10:06
 */
public class WeeklyLog implements Cloneable {
    private String name;
    private String content;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WeeklyLog clone() {
        try {
            Object object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("对象不支持复制");
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeeklyLog weeklyLog = (WeeklyLog) o;

        if (!name.equals(weeklyLog.name)) return false;
        if (!content.equals(weeklyLog.content)) return false;
        return date.equals(weeklyLog.date);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
