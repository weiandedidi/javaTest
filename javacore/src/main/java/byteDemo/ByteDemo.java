package byteDemo;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/8
 * Time: 上午11:24
 */
public class ByteDemo {
    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3, 4, 5};
        StringBuilder reslut = new StringBuilder();
        for (int i = 3; i < bytes.length; i++) {
            reslut = reslut.append(bytes[i]);
        }

        System.out.println(reslut.toString());

    }
}
