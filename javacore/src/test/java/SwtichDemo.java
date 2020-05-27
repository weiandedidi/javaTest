import org.junit.Test;

/**
 * @author qidi
 * @date 2020-05-22 11:06
 */
public class SwtichDemo {

    @Test
    public void testSwitch() {
        print(1);

    }

    public void print(int type) {
        switch (type) {
            case 1:
                type = 3;
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.out.println(5);
                break;
            case 6:
                System.out.println(6);
                break;
            default:
                System.out.println("over");

        }

        System.out.println("最后打印" + type);
    }
}
