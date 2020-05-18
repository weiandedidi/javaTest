import java.util.Random;

/**
 * @author qidi
 * @date 2020-03-31 18:31
 */
public class TryDemo {


    public static void main(String[] args) {
        Random random = new Random();
        int type = random.nextInt(10);
        System.out.println(type);
//        testTry(3);

    }

    public static void testTry(int a) {

        try {
            if (a < 5) {
                throw new NullPointerException("我是空指针");
            }
            System.out.println("a>5");
        } finally {
            System.out.println("最新打印");
        }

    }


}
