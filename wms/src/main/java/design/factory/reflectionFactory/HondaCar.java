package design.factory.reflectionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/22
 * Time: 13:08
 */
public class HondaCar implements Car {
    public void getCarName() {
        System.out.println("this car name id Honda");
    }

    public void getCarNation() {
        System.out.println("my nation is Japan");
    }
}
