package thread.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/6/1
 * Time: 20:32
 */
public class PersonB implements Runnable {
    //
    private Account account;

    public PersonB(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (Account.getMoney() >= 400) {  //每次取200
            Account.getMoneyByATM(400);
        }
    }
}
