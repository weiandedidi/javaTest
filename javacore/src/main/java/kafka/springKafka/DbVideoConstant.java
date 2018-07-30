package kafka.springKafka;

/**
 * DbVideo视频的常量
 *
 * @author: qidima
 * @date: 2018/6/11
 * Time: 19:54
 */
public class DbVideoConstant {
    public static final String ADD = "ADD";    //新增
    public static final String DELETE = "DELETE";  //删除

    public static final Integer STATUS_UN_PUB = 0;  //新建未发布
    public static final Integer STATUS_PUB = 1;     //已发布
    public static final Integer STATUS_DELETE = 2;     //已删除
    public static final Integer NOT_PORN = 0;     //正常视频
    public static final Integer IS_PORN = 1;     //色情视频

    public static final Integer CHECK_UNDO = 0; //未审核
    public static final Integer CHECK_PASS = 1;  //已审核
    public static final Integer CHECK_NO_PASS = 2;    //审核未通过


    public static final Integer SOURCE_AUTO = 1;    //搜狐汽车视频
    public static final Integer SOURCE_SOFA = 2;    //沙发视频


}
