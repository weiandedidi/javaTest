package design.proxy;

/**
 * 案例说明：
 * <p>
 * 某软件公司承接了某信息咨询公司的收费商务信息查询系统的开发任务，该系统的基本需求如下：
 * (1) 在进行商务信息查询之前用户需要通过身份验证，只有合法用户才能够使用该查询系统；
 * (2) 在进行商务信息查询时系统需要记录查询日志，以便根据查询次数收取查询费用。
 * 该软件公司开发人员已完成了商务信息查询模块的开发任务，
 * 现希望能够以一种松耦合的方式向原有系统增加身份验证和日志记录功能，
 * 客户端代码可以无区别地对待原始的商务信息查询模块和增加新功能之后的商务信息查询模块，
 * 而且可能在将来还要在该信息查询模块中增加一些新的功能。
 * 试使用代理模式设计并实现该收费商务信息查询系统。
 * <p>
 * 代理类
 * 类似于fileter的作用，拦截器和过滤
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 17:43
 */
public class Proxy {
    private RealSearcher searcher = new RealSearcher(); //维持一个对真实主题的引用
    private AccessValidator validator;
    private Logger logger;

    public String DoSearch(String userId, String keyword) {
        //如果身份验证成功，则执行查询
        if (validator.validate(userId)) {
            String result = searcher.doSearch(userId, keyword); //调用真实主题对象的查询方法
            this.logger.log(userId); //记录查询日志
            return result; //返回查询结果
        } else {
            return null;
        }
    }

    //创建访问验证对象并调用其Validate()方法实现身份验证
    public boolean validate(String userId) {
        validator = new AccessValidator();
        return validator.validate(userId);
    }

    //创建日志记录对象并调用其Log()方法实现日志记录
    public void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }

}
