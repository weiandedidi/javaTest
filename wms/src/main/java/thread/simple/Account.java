package thread.simple;

/**
 * 银行账户有1000块钱，可以通过柜台，或者ATM取款
 * 线程不安全
 *
 * @author: qidima
 * @date: 2018/6/1
 * Time: 20:20
 */
public class Account {
    private static int money = 500;

    public static void getMoneyByBanker(int money) {
        Account.money -= money;
        System.out.println("柜台取走了" + money + "还剩下" + (Account.money));
    }

    public static synchronized void getMoneyByATM(int money) {
        Account.money -= money;
        System.out.println("ATM取走了" + money + "还剩下" + (Account.money));

    }


    public static int getMoney() {
        return money;
    }
}
