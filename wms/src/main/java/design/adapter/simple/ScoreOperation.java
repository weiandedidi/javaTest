package design.adapter.simple;

/**
 * 操作类接口
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/31
 * Time: 16:41
 */
public interface ScoreOperation {
    public int[] sort(int array[]); //成绩排序
    public int search(int array[],int key); //成绩查找
}
