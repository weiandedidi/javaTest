package design.builder.simple;

/**
 * 角色构建累抽象
 * 1.setPart方法
 * 2.getInstance 方法
 * Created with IntelliJ IDEA.
 * @author maqidi
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

    //工厂方法，返回一个完整的游戏角色对象
    public Actor getActor(){
        return actor;
    }
}