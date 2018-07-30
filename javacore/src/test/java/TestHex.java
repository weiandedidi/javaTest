/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2018/7/11
 * Time: 下午4:29
 */
public class TestHex {
    public static void main(String[] args) {
        byte[] data = {(byte) 256, (byte) 21312314, 3};
        for (int i = 0; i < data.length; i++) {

            System.out.println(data[i]);
        }
        System.out.println(Integer.toBinaryString(21312314));
        System.out.println(Integer.toBinaryString(58));
    }
}
