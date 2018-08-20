package data.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/16
 * Time: 上午10:44
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<String>();
        stringSet.add("a");
        stringSet.add("a");

        Iterator it1 = stringSet.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        Iterator it2 = stringSet.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
