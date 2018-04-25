package data;

import java.util.ArrayList;

/**
 * 图的遍历算法
 * 方法一：采用递归的方式。
 * 定义一个标志数组表示某个结点是否已经被访问过。
 * 以邻接矩阵的形式表示图。
 * 依次对深度遍历图中的每个未被遍历过的结点，针对该结点未被遍历过的邻接点再进行深度遍历，每个结点被遍历后加入到
 * 结果中，并且设定该结点已经被访问过。
 * <p>
 * 使用二维数组标定边
 * <p>
 * User: qidima
 * Date: 2018/4/25
 * Time: 下午8:28
 */
public class GraphDemo {

    /**
     * 标志数组
     */
    public static boolean visited[];
    /**
     *
     */
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<Integer> DFS_Graph1(int graph[][]) {

        int size = graph.length;//求得结点的个数
        visited = new boolean[size];
        /*Step1：依次遍历树中还未被遍历的结点*/
        for (int i = 0; i < size; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                list.add(i);
                /*Step2:深度遍历以结点i为开始的路径上的结点*/
                DFS(graph, i);
            }
        }
        return list;

    }

    /**
     * 深度递归遍历以图中node结点为起点的结点。
     *
     * @param graph
     * @param i
     */
    private static void DFS(int[][] graph, int i) {
        int size = graph.length;
        for (int j = 0; j < size; j++) {
            /*这个当前结点可达且未被访问的结点j才可以*/
            if (graph[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                list.add(j);
                DFS(graph, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[5][5];
        int[] v1 = {0, 1, 0, 1, 0};
        int[] v2 = {1, 0, 1, 0, 1};
        int[] v3 = {0, 1, 0, 1, 1};
        int[] v4 = {1, 0, 1, 0, 1};
        int[] v5 = {0, 1, 1, 1, 0};
        graph[0] = v1;
        graph[1] = v2;
        graph[2] = v3;
        graph[3] = v4;
        graph[4] = v5;
        System.out.println(graph[1][4]);
    }

}
