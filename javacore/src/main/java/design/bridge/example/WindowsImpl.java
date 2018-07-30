package design.bridge.example;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Windows操作系统实现类：具体实现类
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:11
 */
public class WindowsImpl implements ImageImpl{
    public void doPaint(Matrix matrix) {
        //调用Windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows操作系统中显示图像：");
    }
}
