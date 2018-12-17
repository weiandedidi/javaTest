package shift;

/**
 * 移位运算
 *
 * @author qidi
 * @date 2018/12/17 下午8:38
 */
public class ShifDemo {
    public static void main(String[] args) {
        int a = 7;
        int b = 7;
        //右移一位 相当于除以2
        System.out.println(a + b >>> 1);
        //左移一位 相当于乘以2
        System.out.println(a + b << 1);
    }
}
