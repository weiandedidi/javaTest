package guavaStu.map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qidi
 * @date 2018/12/17 下午8:09
 */
public class MutliMapTestV2 {
    public static void main(String[] args) {
        Multimap<Integer, Book> myMultimap = ArrayListMultimap.create();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                String name = "name" + j;
                Book book = new Book(i, name);
                myMultimap.put(i, book);
            }
        }
        System.out.println(myMultimap.keys());
        System.out.println(myMultimap.get(5));

        Multimap<Integer, Multimap<Integer, Book>> myMultiBookmap = ArrayListMultimap.create();

    }

    @Data
    @AllArgsConstructor
    static class BookGroup {
        /**
         * 书组名
         */
        private int groupId;
        /**
         * 所在组别名字
         */
        private String groupName;
    }

    @Data
    @AllArgsConstructor
    static class Book {
        private int bookId;
        private String name;
    }

}
