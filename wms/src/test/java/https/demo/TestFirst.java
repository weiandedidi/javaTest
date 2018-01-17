package https.demo;

import constant.ImageConstant;
import org.junit.Test;
import util.https.HttpsEntry;
import util.https.HttpsTool;
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
     * 成功登录
     *
     * 都是null设置的cookie的锅，再用jsoup试试
     * 问题，使用out流处理不了php的返回
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
        String cookies = HttpsUtils.downloadCaptcha(url, headerMap, null);
        System.out.println("cookiesV1==========================" + cookies);
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
        // 需要导入cookie
        HttpsEntry entryV2 = HttpsUtils.doHttpsPost(url, data, headerMap, cookies);
        String cookiesV2 = entryV2.getCookies();
        System.out.println("cookiesV2==========================" + cookiesV2);
//        //查看我的车源  返回由于字节码原因乱码
//        url = "https://www.iautos.cn/home/usedcar/manage/";
//        headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//        headerMap.put("Accept-Encoding", "gzip, deflate, br");
//        headerMap.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
//        headerMap.put("Connection", "keep-alive");
//        headerMap.put("Host", "www.iautos.cn");
//        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
//        HttpsEntry entryV3 = HttpsUtils.doHttpsGet(url, null, headerMap, cookiesV2);
//        System.out.println("cookiesV3=========================="+entryV3.getCookies());
//        System.out.println(entryV3.getResult());
//        String path = "D:\\imgs\\abc.html";
//        FileWriter fw = new FileWriter(path, true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fw);
//        bufferedWriter.newLine();
//        bufferedWriter.write(entryV2.getResult());
//        bufferedWriter.close();
//        fw.close();
        Map<String, String> cookiesMap = HttpsUtils.packCookiesMap(cookiesV2);
        //3.登录
        System.out.println("cookiesMap"+cookiesMap);
        url = "https://www.iautos.cn/home/usedcar/manage/";
        Map<String, String> headerMapThird = new HashMap<String, String>();
        headerMapThird.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headerMapThird.put("Accept-Encoding", "gzip, deflate, br");
        headerMapThird.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headerMapThird.put("Connection", "keep-alive");
        headerMapThird.put("Host", "www.iautos.cn");
        headerMapThird.put("Host", "www.iautos.cn");
        headerMapThird.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsEntry entryV3 = HttpsTool.getData(url, headerMapThird, cookiesMap);
        System.out.println("cookiesV3==========================" + entryV3.getCookiesMap());
    }

    //1.获取验证 2.码登录 3.获取页面
    //登陆后的cookies需要一直保存
    //TODO cookie的累加拼接在流程里完成
    public void testJsoup() throws Exception {
        //1.验证码
        String url = "https://www.iautos.cn/index.php?c=usedcar&a=get_captcha&key=login";
        Map<String, String> headerMapFirst = new HashMap<String, String>();
        headerMapFirst.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMapFirst.put("Accept-Encoding", "gzip, deflate, br");
        headerMapFirst.put("Connection", "keep-alive");
        headerMapFirst.put("Host", "www.iautos.cn");
        headerMapFirst.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsEntry entryV1 = HttpsTool.downloadCaptcha(url, headerMapFirst, new HashMap<String, String>());
        System.out.println("cookiesV1==========================" + entryV1.getCookiesMap());

        //输入验证码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入验证码：回车结束");
        System.out.println();
        String captcha = sc.nextLine();
        //2.登录
        url = "https://www.iautos.cn/user/login/";
        Map<String, String> headerMapSecond = new HashMap<String, String>();
        headerMapSecond.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headerMapSecond.put("Accept-Encoding", "gzip, deflate, br");
        headerMapSecond.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headerMapSecond.put("Content-Type", "application/x-www-form-urlencoded");
        headerMapSecond.put("Connection", "keep-alive");
        headerMapSecond.put("Origin", "https://www.iautos.cn");
        headerMapSecond.put("Referer", "https://www.iautos.cn/user/login/?backurl=http://www.iautos.cn/beijing/");
        headerMapSecond.put("Host", "www.iautos.cn");
        headerMapSecond.put("Content-Length", "191");
        headerMapSecond.put("Upgrade-Insecure-Requests", "1");
        headerMapSecond.put("Cache-Control", "max-age=0");
        headerMapSecond.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        Map<String, String> paramsMapSecond = new HashMap<String, String>();
        paramsMapSecond.put("username", "九台市诚信车行");
        paramsMapSecond.put("password", "sun15944168129");
        paramsMapSecond.put("validatecode", captcha);
        paramsMapSecond.put("btnSubmit", "登录");
        paramsMapSecond.put("backurl", "http://www.iautos.cn/beijing/");
        HttpsEntry entryV2 = HttpsTool.postData(url, paramsMapSecond, headerMapSecond, entryV1.getCookiesMap());
        System.out.println("cookiesV2==========================" + entryV2.getCookiesMap());

        //3.登录
        url = "https://www.iautos.cn/home/usedcar/manage/";
        Map<String, String> headerMapThird = new HashMap<String, String>();
        headerMapThird.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headerMapThird.put("Accept-Encoding", "gzip, deflate, br");
        headerMapThird.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headerMapThird.put("Connection", "keep-alive");
        headerMapThird.put("Host", "www.iautos.cn");
        headerMapThird.put("Host", "www.iautos.cn");
        headerMapThird.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        HttpsEntry entryV3 = HttpsTool.getData(url, headerMapThird, entryV2.getCookiesMap());
        System.out.println("cookiesV3==========================" + entryV3.getCookiesMap());
    }


    public static void main(String[] args) throws Exception {
        TestFirst first = new TestFirst();
//        first.testJsoup();
        first.testCaptcha();
    }
}
