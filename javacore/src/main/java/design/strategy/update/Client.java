package design.strategy.update;

/**
 * @author qidi
 * @date 2019-03-13 18:02
 */
public class Client {
    public static void main(String[] args) {
        VIP vip = new VIP(100);
        Student student = new Student(100);
        Child child = new Child(100);

        Context context = new Context(CustomerType.getInstance(student.getClass()).getCustomerStrategy());
        System.out.println(context.discount(student.getPrice()));

    }
}
