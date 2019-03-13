package design.prototype.appDemo;

import javax.swing.text.Document;

/**
 * 文件模板页
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/20
 * Time: 17:57
 */
public interface DocumentTemplet extends Cloneable{

    public DocumentTemplet clone();

    public void display();
}
