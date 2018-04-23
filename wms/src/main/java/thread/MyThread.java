package thread;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/4/23
 * Time: 9:29
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I am first thread ...");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }

}

class Mythread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("I am second thread ...");
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}
