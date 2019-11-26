package java8.lamada.func.utils;

import java8.lamada.func.utils.Person;
import java8.lamada.func.utils.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 此函数提供掺入参数方法的方法
 *
 * @author qidi
 * @date 2019-11-26 19:44
 */
public class FunctionUtil {


    /**
     * 根据断言条件predicate判断是否进行操作
     *
     * @param t
     * @param f
     * @param predicate 可以进行函数进行之前的校验操作
     * @param <T>       掺入的入参
     * @param <R>       返回值
     * @return
     */
    public static <T, R> R getResult(T t, Predicate<T> predicate, Function<? super T, R> f) {
        //参数校验
        if (predicate.test(t)) {
            //进行函数调用
            return f.apply(t);
        } else {
            //统一进行错误日志处理
            System.out.println("执行失败记录日志");
            return null;
        }
    }

    /**
     * 通常数据的返回值
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static
    class Result {
        private int code;
        private String message;
        private Object object;
    }

    public static void main(String[] args) {
        //查看年龄大于15岁
        Predicate<Person> predicate = p -> p.getAge() >= 15;
        //查看其count
        Student student = new Student();
        student.setName("ma");
        student.setAge(20);
        Result result = getResult(student, predicate, person -> {
            //数据中返回count
            return new Result(1, "succes", person.showCount());
        });

        System.out.println(result);
    }


}
