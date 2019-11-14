/**
 * 测试2维数组
 *
 * @author qidi
 * @date 2019-11-07 10:25
 */
public class List2 {
    public static void main(String[] args) {
        //二维数组
        int[][] arr = new int[5][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.MAX_VALUE - j;
            }
        }

        System.out.println(arr[2][2]);

        System.out.println("5".equalsIgnoreCase(null));
    }
}
