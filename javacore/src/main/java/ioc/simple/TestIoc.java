package ioc.simple;

/**
 * 测试Ioc
 *
 * @author qidi
 * @date 2019-03-01 17:14
 */
public class TestIoc {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //1. 模拟spring的扫描
        Container container = new Container();
        container.init();
        //2.创造一个人
        Person person = new Person();
        //3.给这个人注入一辆本田的车, 模仿springContext中bean里面定义注入的属性参数
        String carName = "hondaCar";

        //4.展示的是非单例模式的创建，只存一个class的，实例化的时候，通过类反射属性后面创建。
        Object object = container.getBeanMap().get(carName);
        Class clazz = object.getClass();
        clazz.newInstance();
        Car car = (Car) clazz.newInstance();
        car.setName(carName);
        person.setCar(car);
        person.showCar();

        //模拟单例的模式的创建,car是单例的

        Car singletonCar = (Car) container.getSingletonBeanMap().get(carName);
        Person personV2 = new Person();
        personV2.setCar(singletonCar);
        personV2.showCar();
    }
}
