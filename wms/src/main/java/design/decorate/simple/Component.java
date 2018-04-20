package design.decorate.simple;

/**
 * Component充当抽象构件类，
 * 其子类Window、TextBox、ListBox充当具体构件类，
 * Component类的另一个子类ComponentDecorator充当抽象装饰类，
 * ComponentDecorator的子类ScrollBarDecorator和BlackBorderDecorator充当具体装饰类。
 * <p>
 * 案例：
 * Sunny软件公司基于面向对象技术开发了一套图形界面构件库VisualComponent，
 * 该构件库提供了大量基本构件，如窗体、文本框、列表框等，
 * 由于在使用该构件库时，用户经常要求定制一些特效显示效果，
 * 如带滚动条的窗体、带黑色边框的文本框、既带滚动条又带黑色边框的列表框等等，
 * 因此经常需要对该构件库进行扩展以增强其功能
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 16:43
 */
abstract class Component {
    public abstract void display();
}
