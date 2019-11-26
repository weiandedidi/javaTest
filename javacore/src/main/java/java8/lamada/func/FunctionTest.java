package java8.lamada.func;


import java.util.function.Function;

/**
 * 传入function数据
 *
 * @author qidi
 * @date 2019-11-22 20:42
 */
public class FunctionTest<T, R> {

    /**
     * 假设T就是一个String进行拼接
     */
    private Function<T, R> function;

    public FunctionTest() {
        function = t -> (R) ("入参处理函数" + t);
    }

    public static void main(String[] args) {
        FunctionTest<String, String> test = new FunctionTest();
        System.out.println(test.function.apply("aa"));
        FunctionTest<Integer, String> testV1 = new FunctionTest();

        System.out.println(testV1.function.apply(55));
    }

}
