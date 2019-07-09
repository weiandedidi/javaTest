package java8.lamada.grammer;

/**
 * lamada表达式作用域
 * <p>
 * lamda有些简化了匿名内部类的写法
 * 限制原因{@link java8.lamada.grammer}
 * <p>
 * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
 * 如果在匿名类或 Lambda 表达式中访问的局部变量,本地变量，如果不是 final 类型的话，会出错。
 * <p>
 * 原因：因为实例变量存在堆中，而局部变量是在栈上分配，Lambda 表达(匿名类) 会在另一个线程中执行。
 * 如果在线程中要直接访问一个局部变量，可能线程执行时该局部变量已经被销毁了，而 final 类型的局部变量在 Lambda 表达式(匿名类) 中其实是局部变量的一个拷贝。
 */
public class ScopeDemo {


    public static void main(String[] args) {
        int a = 6;
        MathOperation mathOperation = (b) -> b + a;
        System.out.println(mathOperation.plus(4));
//        a = 3;

    }

    interface MathOperation {
        int plus(int param);
    }

}
