/**
 * Created by qidima on 2017/7/4.
 */
public class TestException {

    public void testRuntimeException(){
        throw new RuntimeException("这是个异常");
    }

    public void run() throws Exception{
        testRuntimeException();
        System.out.println("123456");
    }

    public static void main(String[] args) throws Exception {
        TestException exception = new TestException();
        exception.run();
    }
}
