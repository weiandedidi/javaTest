package algorithm.sort;

/**
 * 输入正整数n
 * 计算 [0...n]，n+1个数的1的个数
 *
 * @author qidi
 * @date 2019-09-26 14:22
 */
public class Calculate1s {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        //计算有几个数
        for (int i = 0; i <= num; i++) {
            //一个数有2进制有几个1
            result[i] = calculateOnes(i);
            //返回[0,1,1]这样的结果
        }
        return result;
    }

    //计算2进制中1的个数
    public int calculateOnes(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] result = new Calculate1s().countBits(4);
    }
}
