package java8.lamada;

/**
 * lamada表达式
 * <p>
 * 先定义接口类，接口方法
 * lamda表达式作为实现类
 * User: qidi
 * Date: 2018/12/14
 * Time: 下午8:34
 */
public class LamadaDemoV1 {

    static String salutation = "Hello! ";


    public static void main(String[] args) {
        helloService greetService1 = message -> System.out.println(salutation + message);
        greetService1.say("qidi");
    }

    interface helloService {
        void say(String message);
    }
}
