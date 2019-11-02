import java.util.Objects;

/**
 * @author qidi
 * @date 2019-08-26 21:18
 */
public class ObjectTest {
    public static void main(String[] args) {
        System.out.println(Objects.equals(new Byte("1"), new Byte("1") ));
        System.out.println(Objects.equals(new Byte("1"), "1" ));
        System.out.println(Objects.equals(new Byte("1"), 1 ));
    }
}
