package design.builder.xmlSimple;

/**
 * 角色构建累抽象
 * 1.setPart方法
 * 2.getInstance 方法
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/30
 * Time: 16:56
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    //定义个钩子方法，判断是否设置属性 钩子方法多使用boolean类型isXXX
    public boolean isBareheaded() {
        return false;   //是否光头 否
    }

    public Actor createActor() {
        return actor;
    }
}