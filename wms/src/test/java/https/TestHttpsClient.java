package https;

import org.junit.Test;
import util.https.HttpsUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/1/12
 * Time: 17:20
 */
public class TestHttpsClient {

    private String url = "https://2sc.sohu.com/";
    private String charset = "utf-8";
    private String sysId = "106605";

    @Test
    public void testHttpsPost() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("accept", "*/*");
        headerMap.put("connection", "Keep-Alive");
        headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        Map<String, String> params = new HashMap<String, String>();
        url = "https://pp4.sohuno.com//2.0/api/queryusermobile/106605";
        params.put("passport", "bjac8888@sohu.com");
        String result = HttpsUtils.doHttpsPost(url,params,headerMap);
        System.out.println(result);


    }

    @Test
    public void testHttpsGet() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("accept", "*/*");
        headerMap.put("connection", "Keep-Alive");
        headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");

        String result = HttpsUtils.doHttpsGet(url,null,headerMap);
        System.out.println(result);
    }
}
