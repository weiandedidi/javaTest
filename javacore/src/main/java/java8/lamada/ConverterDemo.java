package java8.lamada;

/**
 * 直接在 lambda 表达式中访问外层的局部变量
 * <p>
 * java: 从lambda 表达式引用的本地变量必须是final变量或实际上的最终变量
 * User: qidi
 * Date: 2018/12/14
 * Time: 下午9:07
 */
public class ConverterDemo {

    public static void main(String[] args) {
        //传入lamda的参数，之后不能修改，因为lamda是后解析的，所以导致传入lamda的参数不知道
         int num = 1;
        Converter<Integer, String> s = (param) -> param + num;
        //结果3
        int x = s.convert(2);
        System.out.println(x);
//        num = 5;

    }

    public interface Converter<T1, T2> {
        int convert(int i);
    }
}
