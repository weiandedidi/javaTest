package https.demo;

import org.junit.Test;
import util.https.HttpsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试第一车网登录
 *
 * @author: qidima
 * @date: 2018/1/15
 * Time: 16:00
 */
public class TestFirst {

    @Test
    public void testDownloadPic() throws Exception {
        //url
        String url = "https://www.iautos.cn/index.php?c=usedcar&a=get_captcha&key=login";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsUtils.downloadImgsByUrl(url,headerMap,null,"first");
    }

//    @Test
    public void testDownloadPicV2() throws Exception {
        //url
        String url = "https://i3.itc.cn/20170830/3640_6e2fcdb5_c8bf_e0b6_4807_009d3c39f5d6_1.jpg";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsUtils.downloadImgsByUrl(url,headerMap,null,"first");
    }
}
