package design.factory.simpleFactory1;

/**
 * 测试类
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/22
 * Time: 17:12
 */
public class ShapeFactoryTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //圆形
        Shape cirle =  shapeFactory.productShape(Circle.class);
        cirle.draw();
        //方形
        Shape square = shapeFactory.productShape(Square.class);
        square.draw();
        //四边形
//        Quadrilateral quadrilateral = shapeFactory.productShape(Quadrilateral.class);   //此句不支持
    }
}
