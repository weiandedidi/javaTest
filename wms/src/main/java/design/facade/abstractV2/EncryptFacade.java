package design.facade.abstractV2;

/**
 * 案例说明：
 * 进阶，将外观类抽象出来，便于以后拓展
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 16:22
 */
public class EncryptFacade implements AbstractEncryptFacade {
    private CipherMachine cipherMachine;
    private FileReader fileReader;

    public EncryptFacade(CipherMachine cipherMachine, FileReader fileReader) {
        this.cipherMachine = cipherMachine;
        this.fileReader = fileReader;
    }

    @Override
    public String encrypt(String filePath) {
        String data = fileReader.read(filePath);
        String result = cipherMachine.Encrypt(data);
        return result;
    }
}
