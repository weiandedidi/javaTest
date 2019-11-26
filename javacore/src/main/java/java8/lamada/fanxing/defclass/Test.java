package java8.lamada.fanxing.defclass;

/**
 * @author qidi
 * @date 2019-11-25 19:46
 */
public class Test {
    public static void main(String[] args) {
        GenericDemoInter<Integer> genericDemoInter = new GenericDemoInterImpl2();
        System.out.println(genericDemoInter.next());
        GenericDemoInter<String> genericDemoInterV2 = new GenericDemoInterImpl1();
        System.out.println(genericDemoInterV2.next());
    }


}
