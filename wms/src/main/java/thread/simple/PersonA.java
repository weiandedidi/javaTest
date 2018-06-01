package thread.simple;

/**
 * 通过柜台员取钱
 *
 * @author: qidima
 * @date: 2018/6/1
 * Time: 20:25
 */
public class PersonA implements Runnable {
    //
    private Account account;

    public PersonA(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        while (Account.getMoney() >= 500) {  //每次取200
            Account.getMoneyByATM(100);
            try {
                Thread.sleep(100); //休息0.1s
                Account.getMoneyByBanker(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
