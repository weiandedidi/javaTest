package ioc.simple;

/**
 * @author qidi
 * @date 2019-03-01 17:15
 */
public class Person {
    /**
     * 这里模拟依赖注入
     */
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * 展示汽车
     */
    public void showCar() {
        car.printBrand();
    }

}
