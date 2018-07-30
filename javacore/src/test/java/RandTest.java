/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/7/5
 * Time: 18:00
 */
public class RandTest {
    public static void main(String[] args) {

        Long playCount = new Double(Math.random()*1000).longValue();

        System.out.println(playCount);

    }
}
