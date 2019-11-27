package java8.lamada.func.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 此函数提供掺入参数方法的方法
 * <p>
 * 函数编程强调一种流式思维，第一个function的结果是第二个function的入参。
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
     * @param before    进行入参打印的函数
     * @param after     进行结果操作的函数
     * @return
     */
    public static <T, R> R getResult(T t, Predicate<T> predicate, Function<? super T, R> f, Function<? super T, T> before, Function<? super R, R> after) {
        //参数校验
        if (predicate.test(t)) {
            //进行函数调用
            return f.compose(before).andThen(after).apply(t);
        } else {
            //统一进行错误日志处理
            System.out.println("执行失败记录日志");
            return null;
        }
    }

    /**
     * 因为没有出参，常用于打印、发送短信等消费动作
     *
     * @param t
     * @param <T>
     */
    public static <T> void printLog(T t) {
        Consumer<T> consumer = t1 -> System.out.println(JSON.toJSONString(t1));
        System.out.println("我是进行consumer的打印类");
        consumer.accept(t);
    }

    /**
     * Supplier常用于业务“有条件运行”时，符合条件再调用获取结果的应用场景；运行结果须提前定义，但不运行。
     * 参数校验
     *
     * @param
     * @return
     */
    public static boolean buildObject() {
        return false;
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
        Function<Person, Result> function = person -> {
            //数据中返回count
            return new Result(1, "succes", person.showCount());
        };

        //function调用操作  比如打印日志
        Function<Person, Person> before = (Person person) -> {
            System.out.println("打印入参" + JSON.toJSONString(person));
            return person;
        };

        //function调用后操作 比如打印日志
        Function<Result, Result> after = (Result result) -> {
            System.out.println("打印结果" + JSON.toJSONString(result));
            return result;
        };

        Result result = getResult(student, predicate, function, before, after);

        printLog(result);
//        function.compose(before).apply(student);
//        function.andThen(after).apply(student);

//        System.out.println(result);
    }


}
