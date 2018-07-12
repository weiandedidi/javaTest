/**
 * Created by qidima on 2017/7/13.
 */
public class TestEqual {
    public static void main(String[] args) {
        Integer messageCode = 5;
        boolean isSucceed = messageCode.equals(0) ? true : false;
        isSucceed = new Long(1000000L).equals(1000000L);
        System.out.println(isSucceed);
    }
}
