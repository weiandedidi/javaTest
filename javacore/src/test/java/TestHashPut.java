import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/7
 * Time: 12:54
 */
public class TestHashPut {
    public static void main(String[] args) {
        Map<Integer, Integer> mapOne = new HashMap<Integer, Integer>();
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            mapOne.put(i, i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("one buy one time is" + (endTime - startTime));

        Map<Integer, Integer> mapTwo = new HashMap<Integer, Integer>();
         long a = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            mapTwo.put(i, i);
        }
         long b = System.currentTimeMillis();
        System.out.println("two buy one time is" + (b - a));

/*        List<Integer> One = new ArrayList<Integer>(10000000);
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            One.add(i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("one buy one time is" + (endTime - startTime));

        List<Integer> Two = new ArrayList<Integer>();
        Long a = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Two.add(i);
        }
        long b = System.currentTimeMillis();
        System.out.println("two buy one time is" + (b - a));*/
    }
}
