package https.demo;

import constant.ImageConstant;
import org.junit.Test;
import util.https.HttpsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试第一车网登录
 * 第一车网是php页面，所以需要兼容php页面，需要使用jsoup
 * https://stackoverflow.com/questions/28619161/getting-captcha-image-using-jsoup
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
        //二手车之家
//        String url = "https://dealers.che168.com/Handler/CreateImgCode.ashx?0.40939860489906055";
        //可以下载gif文件 bilibili的gif图片
//        String url = "https://i0.hdslb.com/bfs/active/1f8aa6cd328fee1eaf61d1f59e40e97addc1aae8.gif";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsUtils.downloadImgsByUrl(url,headerMap,null,"first",ImageConstant.GIF);
    }

    @Test
    public void testDownloadPicV2() throws Exception {
        //url
        String url = "https://i3.itc.cn/20170830/3640_6e2fcdb5_c8bf_e0b6_4807_009d3c39f5d6_1.jpg";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsUtils.downloadImgsByUrl(url,headerMap,null,"first", ImageConstant.JPEG);
    }
}
