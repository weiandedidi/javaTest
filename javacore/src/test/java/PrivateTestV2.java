/**
 * @author qidi
 * @date 2019-02-28 20:29
 */
public class PrivateTestV2 {
    public static void main(String[] args) {
        PrivateTest privateTest = new PrivateTest("a", 5);
//        privateTest.age = 34;
        System.out.println(privateTest.getAge());
    }
}
