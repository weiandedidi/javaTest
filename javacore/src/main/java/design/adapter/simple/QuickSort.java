package design.adapter.simple;

/**
 * 快速排序适配者
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/31
 * Time: 16:43
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param array
     * @param startIndex 左面的坐标
     * @param endIndex   右面的坐标
     * @return
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        //判断非空
        if (null == array || array.length < 1) {
            return;
        }
        algorithm.sort.quick.QuickSort.quickSort(array, startIndex, endIndex);
    }

    /**
     * 快速排序
     *
     * @param array
     */
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        sort.quickSort(a);
        System.out.println(a);
    }
}
