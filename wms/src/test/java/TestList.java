import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qidima on 2017/7/20.
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer e : list) {
            System.out.println(e);
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(list.size());
    }
}
