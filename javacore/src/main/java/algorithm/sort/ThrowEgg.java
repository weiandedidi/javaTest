package algorithm.sort;

/**
 * @author qidi
 * @date 2019-10-10 15:07
 */
public class ThrowEgg {

    public static int findMinLevel(int eggs, int levels) {

        if(eggs<1 || levels<1){
            return 0;
        }
//		第一步，创建动态规划的备忘录，即状态转移矩阵
        int [][]state=new int[eggs+1][levels+1];
//		第二步，考虑边界
//		先考虑eggs边界，eggs为0，则为0；eggs为1，肯定从第0层往上依次实验
        for(int i=1;i<=levels;i++){
            state[0][i]=0;
            state[1][i]=i;
        }
//		再考虑floor的边界，levels为0即为0，levels为1即为1
        for(int i=1;i<=eggs;i++){
            state[i][0]=0;
            state[i][1]=1;
        }
//		第三步就是状态方程了，鸡蛋从第2个开始算,楼层也从第2开始算
        for(int egg=2;egg<=eggs;egg++){
            for(int floor=2;floor<=levels;floor++){
//				你还有egg个鸡蛋，一共有floor层楼的子问题
//				定义一个变量来存储最终结果，找到在哪里扔能达到所扔次数最少的目标
                int result=Integer.MAX_VALUE;
//				从第drop层扔鸡蛋
                for(int drop=1;drop<=floor;drop++){
//					碎了，剩下的问题即如何在drop-1层，用egg-1个鸡蛋寻找最优解
                    int broken=state[egg-1][drop-1];
//					没碎，在levels-drop层，用egg个鸡蛋找最优解
                    int unbroken=state[egg][floor-drop];
//					两种情况取最大值，因为我根本不知道鸡蛋会不会碎
                    int condition=Math.max(broken, unbroken)+1;
//					不断和上一次结果做比较，得到最少的扔次数
                    result=Math.min(condition, result);
                }
                state[egg][floor]=result;
            }
        }
//		以上步骤在不断的往状态举证填充，到这里已经填充完毕
        return state[eggs][levels];
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findMinLevel(1,10));
        System.out.println(findMinLevel(5,10));
        System.out.println(findMinLevel(3,39));
    }

}
