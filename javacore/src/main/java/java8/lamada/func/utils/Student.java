package java8.lamada.func.utils;

import lombok.Data;

/**
 * @author qidi
 * @date 2019-11-26 19:47
 */
public class Student extends Person {
    /**
     * 班级名
     */
    private String clazzName;

    private Integer count = 10;

    @Override
    public int showCount() {
        return getCount();
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
