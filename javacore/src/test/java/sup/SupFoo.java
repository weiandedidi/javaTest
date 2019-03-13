package sup;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 17:12
 */
public class SupFoo extends Foo{
    private Foo foo;

    public SupFoo(Foo foo) {
        this.foo = foo;
        System.out.println("父类构造方法");
    }

    @Override
    public void show() {
        foo.show();
    }
}
