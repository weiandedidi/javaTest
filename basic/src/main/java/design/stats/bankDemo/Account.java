package design.stats.bankDemo;

/**
 * (1) 如果账户中余额大于等于0，则账户的状态为正常状态(NormalState State)，此时用户既可以向该账户存款也可以从该账户取款；
 * (2) 如果账户中余额小于0，并且大于-2000，则账户的状态为透支状态(Overdraft State)，此时用户既可以向该账户存款也可以从该账户取款，但需要按天计算利息；
 * (3) 如果账户中余额等于-2000，那么账户的状态为受限状态(Restricted State)，此时用户只能向该账户存款，不能再从中取款，同时也将按天计算利息；
 * (4) 根据余额的不同，以上三种状态可发生相互转换。
 * 不能深究，当用户在-2000的极限钱取款，就可以一直透支取款
 *
 * @author: qidima
 * @date: 2017/12/13
 * Time: 17:57
 */
public class Account {
    private AccountState state; //维持一个对抽象状态对象的引用
    private String owner; //开户名
    private double balance = 0; //账户余额

    /**
     * 初始化方法，用户名和余额
     *
     * @param owner
     * @param balance
     */
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.state = new NormalStatus(this); //设置初始状态
        System.out.println(this.owner + "开户，初始金额为" + balance);
        System.out.println("---------------------------------------------");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    /**
     * 存款
     * @param amount
     */
    public void deposit(double amount) {
        System.out.println(this.owner + "存款" + amount);
        state.deposit(amount); //调用状态对象的deposit()方法
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ this.state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    /**
     * 取款
     * @param amount
     */
    public void withdraw(double amount) {
        System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount); //调用状态对象的withdraw()方法
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ this. state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    public void computeInterest()
    {
        state.computeInterest(); //调用状态对象的computeInterest()方法
    }
}
