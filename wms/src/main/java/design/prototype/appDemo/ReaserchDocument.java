package design.prototype.appDemo;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/20
 * Time: 18:00
 */
public class ReaserchDocument implements DocumentTemplet {
    //浅克隆方法
    public DocumentTemplet clone() {
        DocumentTemplet documentTemplet = null;
        try {
            documentTemplet = (DocumentTemplet) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("该类" + ReaserchDocument.class.getName() + "不能克隆");
        }
        return documentTemplet;
    }

    public void display() {
        System.out.println("《分析报告》");
    }
}
