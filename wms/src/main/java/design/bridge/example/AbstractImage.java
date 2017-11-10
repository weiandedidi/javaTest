package design.bridge.example;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * 抽象图像类：抽象类
 *
 * @author: qidima
 * @date: 2017/11/9
 * Time: 15:07
 */
abstract class AbstractImage {

    protected ImageImpl imageImpl;

    public void setImageImpl(ImageImpl impl) {
        this.imageImpl = impl;
    }

    /**
     * 解析图像文件，并绘制
     * @param fileName
     */
    public abstract void parseFile(String fileName);
}
