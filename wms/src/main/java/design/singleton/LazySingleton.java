package design.singleton;

/**
 * 懒汉模式，要的时候再给
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/10
 * Time: 19:18
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }
    //锁方法 ==锁类
    public synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

/*    //锁对象
    public LazySingleton getInstance() {
        if (null == instance) {
            synchronized (LazySingleton.class) {    //错误的 因为多个线程都走到这一步，会出现多个实例
                instance = new LazySingleton();
            }
        }
        return instance;
    }*/



}
