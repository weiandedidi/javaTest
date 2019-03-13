package design.builder.simple;

/**
 * 指挥者类ActorController定义了construct()方法，该方法拥有一个抽象建造者ActorBuilder类型的参数，在该方法内部实现了游戏角色对象的逐步构建
 * 制定实例化那种构建者
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/30
 * Time: 17:11
 */
public class ActorController {

    /**
     * 构造方法传入构建者 返回产品
     * @param actorBuilder
     * @return
     */
    public Actor construct(ActorBuilder actorBuilder){
        Actor actor;
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildHairstyle();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actor = actorBuilder.getActor();
        return actor;
    }
}
