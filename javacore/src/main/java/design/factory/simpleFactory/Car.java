package design.factory.simpleFactory;

/**
 * car 抽象产品类，定义获取产品
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/22
 * Time: 13:05
 */
public interface Car {
    /**
     * 获取车的名字
     */
    public void getCarName();

    /**
     * 获取车的国家
     */
    public void getCarNation();
}
