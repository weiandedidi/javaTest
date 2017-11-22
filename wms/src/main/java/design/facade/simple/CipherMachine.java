package design.facade.simple;

/**
 * 数据加密类，充当子系统类。
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 16:39
 */
public class CipherMachine {
    public String  Encrypt(String data){
        //讲明文转为密文
        System.out.println("加密");
        StringBuilder builder = new StringBuilder(data);
        return builder.reverse().toString();
    }
}
