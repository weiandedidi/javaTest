package thread.simple.productconsume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/6/7
 * Time: 18:04
 */
public class WithdrawThread extends Thread {
    Account4 account;

    public WithdrawThread(Account4 acount)
    {
        this.account = acount;
    }

    public void run()
    {
        for (int i = 0; i < 5; i++)
            account.withdraw(100);
    }
}
