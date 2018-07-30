package jvm;

/**
 * Created with IntelliJ IDEA.
 * 测试GC回收是否使用引用计数方法回收.
 * 引用计数方法：
 * 结构中维护一个引用变量，使用了为count+1，使用完了count-1
 * 当没人引用的时候删除 count=0
 * <p>
 * 测试：测试使用了testGC()方法后，objA和obj是否会被回收
 *
 * @author: qidima
 * @date: 2018/4/24
 * Time: 11:43
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1Mb = 1024 * 1024;
    /**
     * 在这个成员属性的作用就是占用内存，一般能够在GC日志中看清回收过程
     */
    private byte[] bigSize = new byte[2 * _1Mb];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设这里发生GC，objA和objB能够被回收。
        //如果是引用计数方式的，循环引用，铁定无法回收
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
