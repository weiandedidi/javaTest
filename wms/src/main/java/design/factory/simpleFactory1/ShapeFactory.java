package design.factory.simpleFactory1;

/**
 * 图形工厂类
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/22
 * Time: 17:05
 */
public class ShapeFactory {
    //生产方法类
    public Shape productShape(Class<? extends Shape> clazz) {
        Shape shape = null;
        try {
            shape = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            //自定义一个异常
            throw new UnSupportedShapeException();
        }
        return shape;
    }
}
