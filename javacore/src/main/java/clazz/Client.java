package clazz;

/**
 * @author qidi
 * @date 2019-04-05 06:55
 */
public class Client {
    public static void main(String[] args) {
        Coo coo = new Coo();
        Aoo a1 = coo;
        Doo doo = new Doo();
        Aoo a2 = doo;

        a1.doAction();
        a2.doAction();
    }
}
