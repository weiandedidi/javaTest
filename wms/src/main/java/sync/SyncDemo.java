package sync;

/**
 * synchronized测试
 *
 * @author: qidima
 * @date: 2018/2/24
 * Time: 10:05
 */
public class SyncDemo {
    Boolean switcher;
    Integer num;

    public void test(boolean on) {

        if (switcher == null) {
            return;
        }
        if (on) {
            synchronized (switcher) {
                System.out.println("ON");
            }
        } else {
            synchronized (switcher) {
                System.out.println("OFF");
            }
        }
    }

    public Boolean getSwitcher() {
        return switcher;
    }

    public void setSwitcher(Boolean switcher) {
        this.switcher = switcher;
    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.setSwitcher(null);
        syncDemo.test(true);

    }
}
