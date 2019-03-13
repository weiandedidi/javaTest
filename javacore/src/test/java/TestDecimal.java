import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qidima on 2017/7/3.
 *
 * @author qidi
 */
public class TestDecimal {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Integer a = 5;
        System.out.println(a.equals(5));

        double b = 12.41;
        BigDecimal big = new BigDecimal(12.41);


        //取整数
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.subList(0, 3);
        integers.subList(4, 5);
        System.out.println(integers.size());
        System.out.println((double) 4 / 51);
        DecimalFormat dec = new DecimalFormat("0.0000");

        Double xx = (double) 4 / 51;
        System.out.println(dec.format(3.555));
        String xxxStr = dec.format(3.555);

        System.out.println(new BigDecimal(xxxStr).setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(2 / 9);
        System.out.println((double) 2 / 9 * 100);
        System.out.println(new BigDecimal((double) 2 / 9 * 100).setScale(2, RoundingMode.HALF_UP));
        System.out.println("=======");
        System.out.println(new Long(5L).toString());


        BigDecimal xxx = new BigDecimal("6.123");
        System.out.println(xxx.subtract(new BigDecimal("5.111")));
        System.out.println(xxx);
        Long aaa = new Long(5);
        System.out.println(aaa);
    }
}
