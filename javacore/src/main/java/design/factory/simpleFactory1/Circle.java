package design.factory.simpleFactory1;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/22
 * Time: 17:01
 */
public class Circle implements Shape {
    public void  draw() {
        System.out.println("i am a circle");
    }

    private void testMethod(){
        System.out.println("hah");
    }

}