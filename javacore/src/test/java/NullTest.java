/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/12/13
 * Time: 下午3:07
 */
public class NullTest {
    static class SubTaskLockInfo {
        String subTaskNo;

        public String getSubTaskNo() {
            return subTaskNo;
        }

        public void setSubTaskNo(String subTaskNo) {
            this.subTaskNo = subTaskNo;
        }
    }

    public static void main(String[] args) {
        SubTaskLockInfo subTaskLockInfo = new SubTaskLockInfo();
        String subTaskNo = null == subTaskLockInfo.getSubTaskNo() ? "" : subTaskLockInfo.getSubTaskNo();
        
        System.out.println(subTaskNo);
    }
}
