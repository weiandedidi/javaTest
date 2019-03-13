package design.factory.reflectionFactory;

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
        Car bwm = carFactory.productCar(BWMCar.class);
        //honda
        Car honda = carFactory.productCar(HondaCar.class);
        //获取车的名字
        bwm.getCarNation();
        honda.getCarNation();

        //追加产品
        Car benz = carFactory.productCar(BenzCar.class);
        benz.getCarNation();

    }
}
