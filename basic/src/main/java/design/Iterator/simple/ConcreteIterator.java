package design.Iterator.simple;

/**
 * 迭代器实例
 * 具体迭代器中将实现抽象迭代器声明的遍历数据
 *
 * @author: qidima
 * @date: 2017/11/29
 * Time: 15:54
 */
public class ConcreteIterator implements Iterator{
    private ConcreteAggregate aggregate;    //维护一个聚合类，为了访问聚合类的数据
    private int cursor; //定义一个游标，用于记录当前访问位置

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void first() {
        //操作this.aggregate
    }

    @Override
    public void next() {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object currentItem() {
        return null;
    }
}
