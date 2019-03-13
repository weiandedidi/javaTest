package sup;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 17:16
 */
public class Client {
    public static void main(String[] args) {
        Foo a;
        Aoo aoo;
        aoo = new Aoo("Aoo");
        a = new SubFoo(aoo);
        a.show();
    }
}
