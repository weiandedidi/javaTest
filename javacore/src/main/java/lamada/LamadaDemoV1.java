package lamada;

/**
 * lamada表达式
 * User: qidi
 * Date: 2018/12/14
 * Time: 下午8:34
 */
public class LamadaDemoV1 {

    final static String salutation = "Hello! ";


    public static void main(String[] args) {
        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
