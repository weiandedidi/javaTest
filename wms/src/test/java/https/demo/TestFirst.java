package https.demo;

import constant.ImageConstant;
import org.junit.Test;
import util.https.HttpsEntry;
import util.https.HttpsUtils;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 测试第一车网登录
 * 第一车网是php页面，所以需要兼容php页面，需要使用jsoup，解析html文件
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
        HttpsUtils.downloadImgsByUrl(url, headerMap, null, "first", ImageConstant.GIF);
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
        HttpsUtils.downloadImgsByUrl(url, headerMap, null, "first", ImageConstant.JPEG);
    }


    /**
     * 登录第一车网
     *
     * @throws Exception
     */
    @Test
    public void testCaptcha() throws Exception {
        //获取验证码
        String url = "https://www.iautos.cn/index.php?c=usedcar&a=get_captcha&key=login";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsUtils.downloadCaptcha(url, headerMap, null);
        //输入验证码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入验证码：回车结束");
        System.out.println();
        String captcha = sc.nextLine();
        //登录拿到cookie
        url = "https://www.iautos.cn/user/login/";
        headerMap.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headerMap.put("Content-Type", "application/x-www-form-urlencoded");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("username", "九台市诚信车行");
        paramsMap.put("password", "sun15944168129");
        paramsMap.put("validatecode", captcha);
        paramsMap.put("btnSubmit", "登录");
        paramsMap.put("backurl", "http://www.iautos.cn/beijing/");
        String data = HttpsUtils.contactGetString(paramsMap);
        HttpsEntry entry = HttpsUtils.doHttpsPost(url, data, headerMap, null);
        String cookies = entry.getCookies();
        System.out.println("cookie==========================" + cookies);
//        //查看我的车源
//        url = "https://www.iautos.cn/home/usedcar/manage/";
//        headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//        headerMap.put("Accept-Encoding", "gzip, deflate, br");
//        headerMap.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
//        headerMap.put("Connection", "keep-alive");
//        headerMap.put("Host", "www.iautos.cn");
//        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
//        HttpsEntry entryV2 = HttpsUtils.doHttpsGet(url, null, headerMap, cookies);
//        System.out.println(entryV2.getResult());
//        String path = "D:\\imgs\\abc.html";
//        FileWriter fw=new FileWriter(path,true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fw);
//        bufferedWriter.newLine();
//        bufferedWriter.write(entryV2.getResult());
//        bufferedWriter.close();
//        fw.close();
        //刷新车源
        url = "https://www.iautos.cn/index.php";
        headerMap.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headerMap.put("Accept-Encoding", "gzip, deflate, br");
        headerMap.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headerMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("Host", "www.iautos.cn");
        headerMap.put("X-Requested-With", "XMLHttpRequest");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        Map<String, String> paramsMapV3 = new HashMap<String, String>();

        paramsMapV3.put("id", "4569068");
        paramsMapV3.put("m", "home");
        paramsMapV3.put("c", "usedcar");
        paramsMapV3.put("a", "CarRefresh");
        String xxx = HttpsUtils.contactGetString(paramsMapV3);
        HttpsEntry entryV3 = HttpsUtils.doHttpsPost(url,xxx,headerMap,cookies);
        System.out.println(entryV3.getResult());

    }

    public static void main(String[] args) throws Exception {
        TestFirst first = new TestFirst();
        first.testCaptcha();
    }
}
