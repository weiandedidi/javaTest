package algorithm.sort;

/**
 * @author qidi
 * @date 2019-11-14 14:37
 */
public class SolutionMaqidi {

    /**
     * 第一人一开始就做对了  +  （没坐在自己和第n人的作为的概率）*f(n-1)
     * f(i)= f(n-1) *(1-2/n)+ 1/n
     *
     * @param n
     * @return
     */
    public static double nthPersonGetsNthSeat(int n) {
        double dp[] = new double[n + 1];
        if (n == 0) {
            dp[0] = 0.0;
        }

        if (n == 1) {
            dp[1] = 1.0;
        }
        //外部变量
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (1.0 - 2.0 / i) + 1.0 / i;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthPersonGetsNthSeat(100));
    }


}
