package sup;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 17:17
 */
public class Aoo extends Foo {
    String name;

    public Aoo(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("Aoo show");
    }
}
