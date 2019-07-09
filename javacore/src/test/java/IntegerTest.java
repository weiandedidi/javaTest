/**
 * @author qidi
 * @date 2019-06-28 15:36
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 11;
        Integer c = a + b;

        Integer d = new Integer(12);
        System.out.println(d.compareTo(c)>0);
    }
}
