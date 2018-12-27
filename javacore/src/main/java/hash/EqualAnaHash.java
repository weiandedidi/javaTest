package hash;

/**
 * @author qidi
 * @date 2018-12-27 13:40
 */
public class EqualAnaHash {
    public static void main(String[] args) {
        Aoo aoo1 = new Aoo("qidi", 1);
        Aoo aoo2 = new Aoo("qidi", 2);

        System.out.println(aoo1.equals(aoo2));

    }
}
