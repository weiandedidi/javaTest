package thread.simple.productconsume;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/6/7
 * Time: 18:05
 */
public class DepositeThread extends Thread {
    Account4 acount;
    public DepositeThread(Account4 acount) {
        this.acount = acount;
    }
    public void run(){
        for(int i=0;i<5;i++)
            acount.deposite(100);
    }
}
