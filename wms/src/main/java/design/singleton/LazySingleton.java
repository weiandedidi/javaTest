package design.singleton;

/**
 * 懒汉模式，要的时候再给
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/10
 * Time: 19:18
 */
public class LazySingleton {
    private LazySingleton instance = null;

    private LazySingleton() {
    }
/*
    //锁方法 ==锁类
    public synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
    */

/*    //锁对象
    public LazySingleton getInstance() {
        if (null == instance) {
            synchronized (LazySingleton.class) {    //错误的 因为多个线程都走到这一步，会出现多个实例
                instance = new LazySingleton();
            }
        }
        return instance;
    }*/

    // 两层锁
    // 需要注意的是，如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
    // 被volatile修饰的成员变量可以确保多个线程都能够正确处理，且该代码只能在JDK 1.5及以上版本中才能正确执行
    public synchronized LazySingleton getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton(); //创建单例实例
                }
            }
        }
        return instance;
    }


}
