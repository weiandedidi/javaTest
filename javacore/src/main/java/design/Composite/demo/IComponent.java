package design.Composite.demo;

/**
 * 组合模式测试类
 * 案例：
 * Sunny软件公司欲开发一个界面控件库，
 * 界面控件分为两大类，
 * 一类是单元控件，例如按钮、文本框等，(此处可以抽离一层，也可以不抽离)
 * 一类是容器控件，例如窗体、中间面板等，试用组合模式设计该界面控件库。
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 11:02
 */
public interface IComponent {
    public void show();
}
