/**
 * @author qidi
 * @date 2019-07-15 16:43
 */
public class IntegerDemo {
    public static void main(String[] args) {
        Integer a = 12;
        Integer b = 12;

        //两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);


    }
}
