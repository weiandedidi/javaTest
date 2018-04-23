package exception;

/**
 * 虚拟机和本地栈的Stack OverflowError的测试
 * 原因，请求的方法的深度大于虚拟机的最大深度
 * 参数：-Xss 减少栈的内存容量
 * -Xss128k
 * 一般情况是递归此处太多
 *
 * @author: qidima
 * @date: 2018/4/23
 * Time: 15:22
 */
public class MyVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        MyVMStackSOF vmStackSOF = new MyVMStackSOF();
        try {
            vmStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length is "+ vmStackSOF.stackLength);
            e.printStackTrace();
        }
    }
}
