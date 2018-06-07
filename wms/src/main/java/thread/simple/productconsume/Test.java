package thread.simple.productconsume;

/**
 * 一个典型的线程同步的应用是生产-消费者模型。其约束条件为：
 * （1）生产者生产产品，并将其保存到仓库中。
 * （2）消费者从仓库中取得产品。
 * （3）由于库房容量有限，因此只有当库房还有空间时，生产者才可以将产品放入库房;否则只能等待。
 * （4）只有库房中存在满足数量的产品时，消费者才能取走产品，否则只能等待。
 * <p>
 * 实际应用中，很多例子都可以归结为该模型。这里举个例子，还是之前存款和取款的问题。
 * 假设存在一个账户对象（仓库）及两个线程：存款线程（生产者）和取款线程（消费者），并对其进行如下的限制：
 * <p>
 * 只有当账户上的余额balance=0时，存款线程才可以存进100元；否则只能等待。
 * 只有当账户上的余额balance=100时，取款线程才可以取走100元；否则只能等待。
 * <p>
 * wait()：阻塞线程，释放互斥对象的互斥锁。（而sleep方法阻塞线程后，并不释放互斥锁）
 * notify()：当另一个线程调用互斥对象的notify()方法时，该互斥对象等待队列中的第一个线程才能进入就绪状态。
 *
 * @author: qidima
 * @date: 2018/6/7
 * Time: 17:56
 */
public class Test {

    public static void main(String[] args) {
        Account4 acount = new Account4();
        WithdrawThread withdraw = new WithdrawThread(acount);
        DepositeThread deposite = new DepositeThread(acount);
        withdraw.start();
        deposite.start();
    }
}
