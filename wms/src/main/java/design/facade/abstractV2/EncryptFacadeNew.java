package design.facade.abstractV2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 17:16
 */
public class EncryptFacadeNew implements AbstractEncryptFacade {
    private CipherMachine cipherMachine;
    private FileReader fileReader;

    public EncryptFacadeNew(CipherMachine cipherMachine, FileReader fileReader) {
        this.cipherMachine = cipherMachine;
        this.fileReader = fileReader;
    }


    @Override
    public String encrypt(String filePath) {
        //新的系统调用方式
        return null;
    }
}
