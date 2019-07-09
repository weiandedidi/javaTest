package guavaStu.precondition;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qidi
 * @date 2019-07-08 12:17
 */

public class PreconditionsTest {
    /**
     * 测试条件判断类 参数异常
     */
    @Test
    public void testCheckArgument() {
        String taskId = null;
        Preconditions.checkArgument(null != taskId, "taskId不能为null");
    }

    /**
     * 非空判断
     */
    @Test
    public void testCheckNotNull() {
        String taskId = null;
        Preconditions.checkNotNull(taskId);
    }

    /**
     * 查看某种状态
     */
    @Test
    public void testCheckStatus() {
        int status = 2;
        Preconditions.checkState(2 == status, "传入状态不为2");
    }

    /**
     * 检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size
     * 避免 IndexOutOfBoundsException
     */
    @Test
    public void testCheckElementIndex() {

        List<Integer> fatherIds = new ArrayList<>();
        Preconditions.checkElementIndex(0, fatherIds.size());
    }



}
