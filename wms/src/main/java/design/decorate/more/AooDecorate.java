package design.decorate.more;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 10:32
 */
public class AooDecorate extends Decorate {


    public AooDecorate(Component component) {
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
    private void doSomeThing(){
        System.out.println("这里是Aoo的拓展方法");
    }

}
