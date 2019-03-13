package design.singleton;

/**
 * 两层锁
 * 需要注意的是，如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
 * 被volatile修饰的成员变量可以确保多个线程都能够正确处理，且该代码只能在JDK 1.5及以上版本中才能正确执行
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/18
 * Time: 11:43
 */
public class LazySingletonDoubleLock {
    private volatile static LazySingletonDoubleLock instance = null;

    //私有的方法
    private LazySingletonDoubleLock() {
    }

    //双重内部锁
    public synchronized LazySingletonDoubleLock getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingletonDoubleLock.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingletonDoubleLock(); //创建单例实例
                }
            }
        }
        return instance;
    }

}
