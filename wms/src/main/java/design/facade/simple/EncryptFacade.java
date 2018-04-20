package design.facade.simple;

/**
 * 案例说明：
 * <p>
 * 某软件公司欲开发一个可应用于多个软件的文件加密模块，
 * 该模块可以对文件中的数据进行加密并将加密之后的数据存储在一个新文件中，
 * 具体的流程包括三个部分，分别是读取源文件、加密、保存加密之后的文件，
 * 其中，读取文件和保存文件使用流来实现，加密操作通过求模运算实现。
 * 这三个操作相对独立，为了实现代码的独立重用，
 * 让设计更符合单一职责原则，这三个操作的业务代码封装在三个不同的类中。
 * 现使用外观模式设计该文件加密模块。
 * <p>
 * 外观类 文件读取类 输出类 加密类
 * <p>
 * 该模块是外观
 *
 * @author: qidima
 * @date: 2017/11/22
 * Time: 16:22
 */
public class EncryptFacade {
    private CipherMachine cipherMachine;
    private FileReader fileReader;

    public EncryptFacade(CipherMachine cipherMachine, FileReader fileReader) {
        this.cipherMachine = cipherMachine;
        this.fileReader = fileReader;
    }

    public String encrypt(String filePath) {
        String data = fileReader.read(filePath);
        String result = cipherMachine.Encrypt(data);
        return result;
    }
}
