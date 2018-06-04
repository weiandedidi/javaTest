package thread.simple.bank;

/**
 * 账户的线程类
 *
 * @author: qidima
 * @date: 2018/6/4
 * Time: 10:28
 */
public class AccountThread extends Thread {
    Account account;

    static int delay;


    public AccountThread(thread.simple.bank.Account account, int delay) {
        this.account = account;
        this.delay = delay;
    }

    /**
     * 每次取100固定，方法锁
     */
/*    public synchronized static void getMoney() {
        if (account.balance >= 100) {
            try {
                sleep(delay);
                account.balance = account.balance - 100;
                System.out.println("withdraw  100 successful!");
            } catch (InterruptedException e) {
            }
        } else
            System.out.println("withdraw failed!");
    }
    */

    /**
     * 对象锁  Account account不是static的,注意这种类锁
     */
   /* public static void getMoney(Account account) {

        synchronized (account) {
            if (account.balance >= 100) {
                try {
                    sleep(delay);
                    account.balance = account.balance - 100;
                    System.out.println("withdraw  100 successful!");
                } catch (InterruptedException e) {
                }
            } else {
                System.out.println("withdraw failed!");
            }
        }

    }*/

    /**
     * 类锁  Account account是static的
     * synchronized (account)相当于锁的是整个AccountThread类，
     * 注意：
     * AccountThread AccountThread1 = new AccountThread(account, 1000);
     * AccountThread AccountThread2 = new AccountThread(account1, 0);
     * 在传入不同account时候，由于是AccountThread类被锁住，导致account的内部的account 在执行一次后还是0，导致数据有问题
     * <p>
     * 结果：
     * Totle Money: 100.0
     * Totle Money: 100.0
     * withdraw  100 successful!
     * withdraw failed!
     * <p>
     * 应该是：
     * Totle Money: 100.0
     * Totle Money: 100.0
     * withdraw  100 successful!
     * withdraw  100 successful!
     */
    public static void getMoney(Account account) {

        synchronized (account) {
            if (account.balance >= 100) {
                try {
                    sleep(delay);
                    account.balance = account.balance - 100;
                    System.out.println("withdraw  100 successful!");
                } catch (InterruptedException e) {
                }
            } else {
                System.out.println("withdraw failed!");
            }
        }

    }


    @Override
    public void run() {
        getMoney(this.account);
    }


}
