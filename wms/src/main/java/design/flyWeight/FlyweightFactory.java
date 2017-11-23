package design.flyWeight;

import java.util.HashMap;

/**
 * 享元工厂，对外输出享元
 * 使用单例模式进行设计
 * 内部维护一个hashMap，里面的元素不可被修改
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 16:30
 */
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();
    private static HashMap<Object, Flyweight> map;

    private FlyweightFactory() {
        map = new HashMap<Object, Flyweight>();
        //提前设置好
        map.put("one", new ConcreteV1());
        map.put("two", new ConcreteV2());
    }

    //返回享元工厂类的唯一实例
    public static FlyweightFactory getInstance() {
        return factory;
    }

    //通过key来获取存储在Hashtable中的享元对象
    public Flyweight getFlyweightByKey(Object key){
        return this.map.get(key);
    }
}
