package java8.lamada.func.utils;

/**
 * @author qidi
 * @date 2019-11-26 19:48
 */
public class Teacher extends Person {
    /**
     * 学科
     */
    private String subject;

    private Integer count = 100;

    @Override
    public int showCount() {
        return getCount();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
