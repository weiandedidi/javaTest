package lock;

/**
 * 这个是使用 idea的模板生成的单例，静态内部类
 * @author qidi
 * @date 2019-01-18 20:15
 */
public class ABC {
    private static ABC ourInstance = new ABC();

    public static ABC getInstance() {
        return ourInstance;
    }

    private ABC() {
    }
}
