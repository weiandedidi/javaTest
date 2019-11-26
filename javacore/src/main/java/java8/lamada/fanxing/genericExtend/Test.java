package java8.lamada.fanxing.genericExtend;

/**
 * 上界<? extends T>不能往里存，只能往外取，适合频繁往外面读取内容的场景。
 * 下界<? super T>不影响往里存，但往外取只能放在Object对象里，适合经常往里面插入数据的场景。
 * 只读不可写时,使用List<? extends Fruit>:Producer
 * 只写不可读时,使用List<? super Apple>:Consumer
 *
 * 如果你既要获取又要放置元素，则不使用任何通配符。例如List<Apple>
 *
 * @author qidi
 * @date 2019-11-25 21:34
 */
public class Test {
    public static void main(String[] args) {
//        Plate<Fruit> p=new Plate<Apple>(new Apple());
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
//        p.set(new Fruit());
//        p.set(new Apple());

        p.get();

        Plate<? super Apple> pv2 = new Plate<>(new Apple());
//        pv2.get();
        pv2.set(new Apple());

    }
}
