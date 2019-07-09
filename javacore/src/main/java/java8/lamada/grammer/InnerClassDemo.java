package java8.lamada.grammer;

/**
 * 匿名内部类的final展示
 *
 * @author qidi
 * @date 2019-07-09 20:12
 */
public class InnerClassDemo {

    public static void main(String[] args) {

        int a = 5;
//        a = 6;
        ScopeDemo.MathOperation mathOperation = new ScopeDemo.MathOperation() {
            @Override
            public int plus(int b) {
                return b + a;
            }
        };



    }

    interface MathOperation {
        int plus(int param);
    }
}
