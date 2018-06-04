package keyword;

/**
 * static 会被共享，洗刷掉
 *
 * @author: qidima
 * @date: 2018/6/4
 * Time: 11:07
 */
public class StaticDemo {
    static private int age;

    public StaticDemo(int age) {
        this.age = age;
    }

    public static int getAge() {
        return age;
    }

    public static void main(String[] args) {
        StaticDemo demo = new StaticDemo(5);
        System.out.println(demo.getAge());
        System.out.println("===============================");
        StaticDemo demo1 = new StaticDemo(6);
        System.out.println(demo1.getAge());
        System.out.println("===============================");
        System.out.println(demo.getAge());

    }
}
