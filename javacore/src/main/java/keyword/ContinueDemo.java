package keyword;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/15
 * Time: 下午9:07
 */
public class ContinueDemo {
    public static void main(String[] args) {
        try {

            System.out.println(1);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(2);
        }

    }
}
