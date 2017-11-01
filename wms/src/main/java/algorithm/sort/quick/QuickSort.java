package algorithm.sort.quick;

/**
 * 快速排序
 * 思想：分而治之，用基准先分堆，然后在堆里面找基准在排序（递归），
 * 关键点：
 * 1.基准
 * 2.左右交换
 * 3.递归
 * 此方法只能是使用最左侧的元素作为基准
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/11/1
 * Time: 10:45
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }

        int left = startIndex;  //左游标
        int right = endIndex;   //右游标
        int standard = arr[left];   //基准
        while (left < right) {
            while (left < right && arr[right] >= standard) {    //比starder大的只是right游标左一，arr数值不发生变化
                right--;
            }
            arr[left] = arr[right];                             //比中轴小的记录移到低端
            while (left < right && arr[left] <= standard) {     //比starder小的只是left游标右移，arr数值不发生变化
                left++;
            }
            arr[right] = arr[left];                             //比中轴大的记录移到高端
        }
        arr[left] = standard;                                   //中轴记录到
        quickSort(arr, startIndex + 1, endIndex);   //左侧排序
        quickSort(arr, startIndex, endIndex - 1);   //右侧排序
    }

    /**
     * 如果是 49, 38开头只能是0开始  如果前面的已经排完了，只需改变starIndex的 例如 4, 5, 49可以从2开始
     *
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {4, 5, 49, 38, 65, 97, 76, 34, 13, 27, 49, 78, 34, 12, 64, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 34, 53, 51};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(" " + a[i]);
        }
    }

}
