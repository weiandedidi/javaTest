package java8.lamada.grammer;

/**
 * lamada表达式
 * <p>
 * 先定义接口类，接口方法
 * lamda表达式作为实现类
 * User: qidi
 * Date: 2018/12/14
 * Time: 下午8:34
 */
public class LamadaDemo {

    static String salutation = "Hello! ";


    public static void main(String[] args) {
        //简单实现
        helloService greetService1 = message -> System.out.println(salutation + message);
        greetService1.say("qidi");

        //加法实现
        MathOperation plus = (x, y) -> x + y;

        //减法实现
        MathOperation sub = (x, y) -> x - y;

        System.out.println(plus.operation(3, 2));
        System.out.println(sub.operation(3, 2));

    }


    interface helloService {
        void say(String message);
    }

    /**
     * 数学操作接口类
     */
    interface MathOperation {
        int operation(int x, int y);
    }

}
