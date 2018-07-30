package design.prototype.appDemo;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/20
 * Time: 19:10
 */
public class Client {
    public  static void main(String args[])
    {
        //获取原型管理器对象
        DocumentHandle handle =  DocumentHandle.getHandle();

        DocumentTemplet  doc1,doc2,doc3,doc4;

        doc1  = handle.getTempletByName("design.prototype.appDemo.ReaserchDocument");
        doc1.display();
        doc2  = handle.getTempletByName("design.prototype.appDemo.ReportDocument");
        doc2.display();
        System.out.println(doc1  == doc2);

        doc3  = handle.getTempletByName("design.prototype.appDemo.ReportDocument");
        doc3.display();
        doc4  = handle.getTempletByName("design.prototype.appDemo.ReaserchDocument");
        doc4.display();
        System.out.println(doc3  == doc4);
    }
}
