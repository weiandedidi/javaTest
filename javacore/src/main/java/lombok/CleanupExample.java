package lombok;

import java.io.*;

/**
 * 实现最终的流关闭详见例子，有待考察
 * https://projectlombok.org/features/Cleanup
 *
 * @author qidi
 * @date 2020-01-14 17:38
 */
public class CleanupExample {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/qidi/Desktop/abc.log";
        String fileCopyPath = "/Users/qidi/Desktop/abc_copy.log";
        @Cleanup InputStream in = new FileInputStream(filePath);
        @Cleanup OutputStream out = new FileOutputStream(fileCopyPath);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }
}
