package design.Iterator.example;

import java.util.ArrayList;
import java.util.List;

/**
 *  Sunny软件公司为某商场开发了一套销售管理系统，
 *  在对该系统进行分析和设计时，
 *  Sunny软件公司开发人员发现经常需要对系统中的商品数据、
 *  客户数据等进行遍历，为了复用这些遍历代码
 *
 * 抽象聚合类，定义数据的增删改查
 * @author: qidima
 * @date: 2017/11/29
 * Time: 16:49
 */
public abstract class AbstractObjectList {
    protected List<Object> datas = new ArrayList<Object>(); //数据源

    public AbstractObjectList(List objects) {
        this.datas = objects;
    }

    public void addObject(Object obj) {
        this.datas.add(obj);
    }

    public void removeObject(Object obj) {
        this.datas.remove(obj);
    }

    public List getObjects() {
        return this.datas;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator iterator();
}
