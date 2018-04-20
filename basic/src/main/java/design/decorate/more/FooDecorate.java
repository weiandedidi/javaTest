package design.decorate.more;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 10:31
 */
public class FooDecorate extends Decorate {


    public FooDecorate(Component component) {
        super(component);
    }

    @Override
    public void show() {
        //想进行之前的方法
        component.show();
        //进行拓展方法
        doSomeThing();
    }

    //拓展方法
    private void doSomeThing() {
        System.out.println("这里是Foo的拓展方法");
    }

}
