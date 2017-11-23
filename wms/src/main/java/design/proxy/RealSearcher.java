package design.proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 17:51
 */
public class RealSearcher implements Search {
    @Override
    public String doSearch(String userId, String keyword) {
        //模拟查询商务信息
        System.out.println("用户'" + userId + "'使用关键词'" + keyword + "'查询商务信息！");
        return "返回具体内容";
    }
}
