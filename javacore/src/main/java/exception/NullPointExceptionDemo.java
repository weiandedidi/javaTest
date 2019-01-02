package exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * sonar 检查不出来null point exception
 *
 * @author qidi
 * @date 2019-01-02 19:29
 */
public class NullPointExceptionDemo {
    @Data
    @AllArgsConstructor
    static class Aoo {
        private String name;
        private Integer age;
    }

    public static void main(String[] args) {
        Aoo aoo = new Aoo("qidi", 18);
        aoo.setAge(null);
        calAooAge(aoo);
    }


    public static void calAooAge(Aoo aoo) {
        System.out.println(aoo.getAge() + 5);
    }
}
