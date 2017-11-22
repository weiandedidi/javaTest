package design.singleton;

/**
 *  *

 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/10
 * Time: 19:18
 */
public final  class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public EagerSingleton getInstance(){
        return instance;
    }
}
