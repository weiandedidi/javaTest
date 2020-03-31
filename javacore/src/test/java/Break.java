/**
 * @author qidi
 * @date 2020-03-27 19:28
 */
public class Break {
    public static void main(String[] args) {
        int a = 5;
        switch (a) {
            case 5:
                if (a == 5) {
                    System.out.println("我先跳出了");
                    break;
                }
                System.out.println("我后跳出了");
                break;
        }

        int aa = 6;
        Long b = (long) aa;
        System.out.println(b);


    }
}
