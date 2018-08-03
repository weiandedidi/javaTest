package params;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * compareAndSet(int expect, int update)
 * 内存中的值 == expect值的时候
 * update成updat的值
 *
 * User: qidi
 * Date: 2018/8/3
 * Time: 下午2:17
 */
public class AtomicIntegerTest {

    AtomicInteger foo;

    public AtomicIntegerTest() {
        this.foo = new AtomicInteger(0);
    }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        atomicIntegerTest.foo.compareAndSet(3, 5);
        System.out.println(atomicIntegerTest.foo);
        atomicIntegerTest.foo.compareAndSet(0, 3);
        System.out.println(atomicIntegerTest.foo);
    }
}
