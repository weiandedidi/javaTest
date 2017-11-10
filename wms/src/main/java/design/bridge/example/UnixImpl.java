package design.bridge.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:13
 */
public class UnixImpl implements ImageImpl {
    public void doPaint(Matrix matrix) {
        //调用Unix系统的绘制函数绘制像素矩阵
        System.out.print("在Unix操作系统中显示图像：");
    }
}
