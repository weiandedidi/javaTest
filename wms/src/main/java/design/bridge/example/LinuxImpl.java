package design.bridge.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:12
 */
public class LinuxImpl implements ImageImpl{
    @Override
    public void doPaint(Matrix matrix) {
        //调用Linux系统的绘制函数绘制像素矩阵
        System.out.print("在Linux操作系统中显示图像：");
    }
}
