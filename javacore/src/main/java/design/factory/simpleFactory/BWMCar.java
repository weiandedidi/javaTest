package design.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/22
 * Time: 13:08
 */
public class BWMCar implements Car{
    public void getCarName() {
        System.out.println("this car name id bmw");
    }

    public void getCarNation() {
        System.out.println("my nation is German");
    }

}
