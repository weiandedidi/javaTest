package design.bridge.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:21
 */
public class JPGImage extends AbstractImage {
    @Override
    public void parseFile(String fileName) {
        //模拟解析JPG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imageImpl.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}
