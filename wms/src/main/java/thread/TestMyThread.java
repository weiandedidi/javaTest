package thread;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/4/23
 * Time: 9:34
 */
public class TestMyThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Mythread2 mythread2 = new Mythread2();
        myThread.start();
        mythread2.start();
    }
}
