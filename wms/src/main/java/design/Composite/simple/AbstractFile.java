package design.Composite.simple;

/**
 * 抽象构件 Component
 *
 * @author: qidima
 * @date: 2017/11/20
 * Time: 17:01
 */
public interface AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
