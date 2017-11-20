package design.Composite.doubles;

/**
 * 两种抽象组件
 * 安全模式：不包含增、删、改方法、 容器类自己实现增、删、改方法
 * 透明模式：组件包含增删改方法的默认实现
 *
 * @author: qidima
 * @date: 2017/11/20
 * Time: 17:59
 */
public abstract class Compnent {
    /*    //安全模式
        public abstract void killVirus();*/


    //透明模式
    public void add(Compnent file) {
        System.out.println("对不起，不支持该方法！");
    }

    public void remove(Compnent file) {
        System.out.println("对不起，不支持该方法！");
    }

    public Compnent getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    public abstract void killVirus();

}
