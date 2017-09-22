package design.factory.reflectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂类，定义产车接口
 * 使用类反射机制解决 增加一个产品时，都需要增加一个对象实现工厂的缺点
 * 使用泛型
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/22
 * Time: 13:04
 */
public class CarFactory {

    //生产车的方法，使用类反射机智
    public Car productCar(Class<? extends Car> clazz) {
        Car car = null;
        try {
            car = (Car) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return car;
    }
}
