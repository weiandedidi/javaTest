package design.factory.simpleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂类，定义产车接口
 * 使用类反射机制解决 增加一个产品时，都需要增加一个对象实现工厂的缺点
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/22
 * Time: 13:04
 */
public class CarFactory {
    Map<String,Car> carMap = new HashMap<String, Car>(){
        {
            put("bwm",new BWMCar());
            put("honda",new HondaCar());
        }
    };
    public Car productCar(String carName){
        return this.carMap.get(carName);
    }
}
