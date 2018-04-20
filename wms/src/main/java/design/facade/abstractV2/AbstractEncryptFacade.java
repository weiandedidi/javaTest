package design.facade.abstractV2;

/**
 * 将外观类抽象出来，便于以后拓展
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 17:14
 */
public interface AbstractEncryptFacade {
    public String encrypt(String filePath);
}
