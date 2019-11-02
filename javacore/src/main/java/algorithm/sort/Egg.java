package algorithm.sort;

/**
 * @author qidi
 * @date 2019-10-17 13:03
 */
public class Egg {
    public static void main(String[] args) {

        int times = getLeastTimes(10, 3);
        System.out.println(times);
        times = getLeastTimes(9, 5);
        System.out.println(times);

    }


    //假设f{n,m}表示n层楼、m个鸡蛋时找到最高楼层的最少尝试次数
    // f{n, m} = min(1 + max(f{i - 1, m - 1}, f{n - i, m}) ) 其中： i为(1, n), f{i, 1} = 1

    /**
     * n层楼m个鸡蛋，找到最高楼层的最少尝试次数
     *
     * @param n
     * @param m
     * @return
     */
    private static int getLeastTimes(int n, int m) {
        if (n == 0 || 0 == m) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        //第一层的
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }

        //大楼层数i
        for (int i = 2; i <= n; i++) {
            dp[i][1] = i;
            //鸡蛋数k
            for (int k = 2; k <= m; k++) {
                //从第j层开始扔
                //写入最大校验值。
                dp[i][k] = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++) {
                    //j的遍历相当于把每层都试一遍
                    int tmp = 1 + max(dp[j - 1][k - 1], dp[i - j][k]);
                    //f{n,m}最小值比较，
                    if (tmp < dp[i][k]) {
                        dp[i][k] = tmp;
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
