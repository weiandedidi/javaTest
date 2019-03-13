package design.builder.xmlSimple;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/30
 * Time: 17:03
 */
public class HeroBuilder extends ActorBuilder {
    public void buildType() {
        actor.setType("英雄");
    }

    public void buildSex() {
        actor.setSex("男");
    }

    public void buildFace() {
        actor.setFace("英俊");
    }

    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    public void buildHairstyle() {
        actor.setHairstyle("飘逸");
    }
}
