package design.Composite.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/21
 * Time: 11:22
 */
public abstract class Container implements IComponent {
    String name;
    List<Container> compnents = new ArrayList<Container>();

    public void add(IComponent compnent) {
        compnents.add((Container) compnent);
    }

    public void remove(IComponent compnent) {
        compnents.remove(compnent);
    }

    public IComponent getChild(int i) {
        return (IComponent) compnents.get(i);
    }

    public void show(){
        for (IComponent iComponent : compnents) {
            iComponent.show();
        }
    }

}
