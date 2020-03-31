/**
 * @author qidi
 * @date 2020-02-24 22:37
 */
public class IntegerCompareTest {
    public static void main(String[] args) {
        Integer a = new Integer(5);
        int b = 5;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(b == a);

        int x = 1565941179;
//        System.out.println(x);

        int tryTimes = 0;
        while (tryTimes++ < 3) {
            System.out.println("times"+tryTimes);
        }

    }
}
