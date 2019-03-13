package design.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/22
 * Time: 13:15
 */
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        //bmw
        Car bwm = carFactory.productCar("bwm");
        //honda
        Car honda = carFactory.productCar("honda");
        //获取车的名字
        bwm.getCarNation();
        honda.getCarNation();
    }
}
