package design.prototype.appDemo;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/20
 * Time: 18:00
 */
public class ReportDocument implements DocumentTemplet {
    public DocumentTemplet clone() {
        DocumentTemplet documentTemplet = null;
        try {
            documentTemplet = (DocumentTemplet) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("该类"+ReportDocument.class.getName()+"不支持复制");
        }
        return documentTemplet;
    }

    public void display() {
        System.out.println("回报报告");
    }
}
