package design.Iterator.simple;

/**
 * 返回数据结构
 *
 * @author: qidima
 * @date: 2017/11/29
 * Time: 16:37
 */
public class ConcreteAggregate implements Aggregate {

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }
}
