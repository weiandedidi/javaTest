package algorithm.sort;

/**
 * @author qidi
 * @date 2019-10-10 15:27
 */
public class ThrowBottle {
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int floorThr(int N, int eggs) {
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        //鸡蛋循环
        for (int egg = 2; egg <= eggs; egg++) {

            //大楼层数i
            for (int i = 2; i <= N; i++) {
                dp[i] = i;
                //从第j层开始扔
                for (int j = 1; j < i; j++) {
                    //j的遍历相当于把每层都试一遍
                    int tmp = max(j, 1 + dp[i - j]);
                    //最大和最小
                    if (tmp < dp[i]) {
                        dp[i] = tmp;
                    }
                }
            }

        }

        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
