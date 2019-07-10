package guavaStu.map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Set;

/**
 * Guava 之 Multimap
 * 多映射的多功能map
 * 可实现一个k对应多个v
 * <p>
 * User: qidi
 * Date: 2018/12/14
 * Time: 下午8:24
 */
public class MutliMapTest {

    public static void main(String[] args) {
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // Adding some key/value
        multimap.put("Fruits", "Bannana");
        multimap.put("Fruits", "Apple");
        multimap.put("Fruits", "Pear");
        multimap.put("Fruits", "Pear");
        multimap.put("Vegetables", "Carrot");

        // Getting the size
        int size = multimap.size();
        System.out.println(size);

        // Getting values
        Collection<String> fruits = multimap.get("Fruits");
        System.out.println(fruits); //  [Bannana, Apple, Pear, Pear]
        // [Bannana, Apple, Pear]
        System.out.println(ImmutableSet.copyOf(fruits));

        Collection<String> vegetables = multimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]

        // Iterating over entire Mutlimap
        for (String value : multimap.values()) {
            System.out.println(value);
        }

        // Removing a single value
        multimap.remove("Fruits", "Pear");
        System.out.println(multimap.get("Fruits")); // [Bannana, Apple, Pear]

        // Remove all values for a key
        multimap.removeAll("Fruits");
        System.out.println(multimap.get("Fruits")); // [] (Empty Collection!)


    }
}
