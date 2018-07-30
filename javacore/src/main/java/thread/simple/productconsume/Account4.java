package thread.simple.productconsume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/6/7
 * Time: 18:00
 */
public class Account4 {
    double balance;

    public Account4() {
        balance = 0;
        System.out.println("Totle Money: " + balance);
    }

    /**
     * 取款
     *
     * @param money
     */
    public synchronized void withdraw(double money) {
        if (balance == 0) {//不能取款
            try {
                wait();
            } catch (InterruptedException e) {
            }
            balance = balance - money;
            System.out.println("withdraw 100 success");
            notify();     //使存款线程进入就绪状态

        }
    }

    /**
     * 存款
     */
    public synchronized void deposite(double money) {
        if (balance != 0)
            try {
                wait();      //使存款线程进入阻塞状态，并释放互斥对象的互斥锁
            } catch (InterruptedException e) {
            }
        balance = balance + money;
        System.out.println("deposite 100 success");
        notify();       //使取款线程进入就绪状态
    }
}
