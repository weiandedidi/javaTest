package design.stats.workFlow;

/**
 * 工作流或者游戏开发的demo应用
 *工作节点，包含不同的工作状态
 * @author: qidima
 * @date: 2017/12/15
 * Time: 15:05
 */
public abstract class Node {
    /**
     * 节点名字
     */
    public String name;

    public abstract void nodeHandle(FlowContext context);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
