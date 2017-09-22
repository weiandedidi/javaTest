import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qidima on 2017/7/3.
 */
public class TestTime {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Integer a = 5;
        System.out.println(a.equals(5));

        double b = 12.41;
        BigDecimal big = new BigDecimal(12.41);


        //jiequ
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.subList(0,3);
        integers.subList(4,5);
        System.out.println(integers.size());
    }
}
