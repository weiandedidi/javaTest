package data.map;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.Objects;

/**
 * @author qidi
 * @date 2018-12-29 16:46
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Aoo, Integer> map = Maps.newHashMap();
        Aoo aooV1 = new Aoo(1, "qidi", 15);
        Aoo aooV2 = new Aoo(2, "qidi", 15);
        System.out.println(aooV1.hashCode());
        System.out.println(aooV2.hashCode());
        map.put(aooV1, 1);
        map.put(aooV2, 2);
        System.out.println(map.toString());
        System.out.println(map.keySet().iterator().next().getId());
    }


    static class Aoo {
        private Integer id;
        private String name;
        private Integer age;

        public Aoo(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Aoo aoo = (Aoo) o;
            return Objects.equals(name, aoo.name) &&
                    Objects.equals(age, aoo.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
