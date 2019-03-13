package thead;

/**
 * 移位运算
 * @author maqidi
 * Date: 2018/5/29
 * Time: 下午9:40
 */
public class moveCal {
    public static void main(String[] args) {
        int abc = -1 << Integer.SIZE - 3;
//        abc = -1 << 1;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(abc));
        System.out.println(abc);
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
    }
}
