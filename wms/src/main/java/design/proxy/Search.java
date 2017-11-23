package design.proxy;

/**
 * 抽象类，定义可查询接口
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 17:44
 */
public interface Search {
    /**
     * 查询方法
     * @param userId 用户id
     * @param keyword   关键字
     * @return
     */
    public String doSearch(String userId,String keyword);
}
