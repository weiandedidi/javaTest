package design.builder.xmlSimple;

/**
 * 控制类
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/31
 * Time: 15:02
 */
public class ActorController {

    public  Actor construct(ActorBuilder ab){
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        //通过钩子方法来控制产品的构建
        if (!ab.isBareheaded()){
            ab.buildHairstyle();
        }
        actor = ab.createActor();
        return actor;
    }
}
