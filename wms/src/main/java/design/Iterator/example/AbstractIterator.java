package design.Iterator.example;

/**
 * 实现创建迭代器对象的具体工厂方法
 *
 * @author: qidima
 * @date: 2017/11/29
 * Time: 16:53
 */
public interface AbstractIterator {
    public void next(); //移至下一个元素
    public boolean isLast(); //判断是否为最后一个元素
    public void previous(); //移至上一个元素
    public boolean isFirst(); //判断是否为第一个元素
    public Object getNextItem(); //获取下一个元素
    public Object getPreviousItem(); //获取上一个元素

}
