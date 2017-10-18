package design.singleton;

/**
 * 静态内部类，单例模式
 * 单例类中增加一个静态(static)内部类，在该内部类中创建单例对象，再将该单例对象通过getInstance()方法返回给外部使用
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/11
 * Time: 下午8:44
 */
public class InnerSingleton {
    //私有构造方法
    private InnerSingleton() {
    }

    //静态内部类
    private static class HolderClass {
        private static final InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return HolderClass.instance;

    }

    public static void main(String[] args) {
        InnerSingleton s1, s2;
        s1 = InnerSingleton.getInstance();
        s2 = InnerSingleton.getInstance();
        System.out.println(s1 == s2);
    }
}
