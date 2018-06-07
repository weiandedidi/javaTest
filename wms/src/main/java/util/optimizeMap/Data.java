package util.optimizeMap;

/**
 * 存储数据的data类
 *
 * @author: qidima
 * @date: 2018/6/4
 * Time: 15:17
 */
public class Data {
    private volatile int i;

    public void testPlus(int i) {
        i = 9;
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.testPlus(data.i);
    }
}
