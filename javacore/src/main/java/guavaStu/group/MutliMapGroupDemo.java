package guavaStu.group;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Guava 之 Multimap 进行分组
 *
 * @author qidi
 * @date 2019-01-17 19:28
 */
public class MutliMapGroupDemo {
    public static void main(String[] args) {

        Multimap<Integer, Aoo> myMultimap = ArrayListMultimap.create();
        for (int i = 0; i < 10; i++) {
            int d = i % 2;
            myMultimap.put(d, new Aoo(d, "name" + i));
        }
        
        myMultimap.keySet().forEach(key -> {
            System.out.println(myMultimap.get(key));
        });
    }

    @Data
    @AllArgsConstructor
    static class Aoo {
        private int id;
        private String name;
    }
}

