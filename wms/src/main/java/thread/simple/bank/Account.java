package thread.simple.bank;

/**
 * 账户类，
 *
 * @author: qidima
 * @date: 2018/6/4
 * Time: 10:27
 */
public class Account {
    double balance;

    public Account(double money) {
        balance = money;
        System.out.println("Totle Money: " + balance);
    }
}
