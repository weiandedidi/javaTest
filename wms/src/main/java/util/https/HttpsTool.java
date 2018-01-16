package util.https;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * 使用jsoup爬网页
 *
 * @author: qidima
 * @date: 2018/1/16
 * Time: 15:27
 */
public class HttpsTool {

    /**
     * 下载验证码
     *
     * @param url
     * @param headerMap
     * @param cookies
     * @throws Exception
     */
    public static void downloadCaptcha(String url, Map<String, String> headerMap, Map<String, String> cookies) throws Exception {
        //connect
        Connection connection = Jsoup.connect(url)
                .ignoreContentType(true)
                .ignoreContentType(true)
                .method(Connection.Method.GET).timeout(30000);
        //set header
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            connection.header(entry.getKey(), entry.getValue());
        }
        //set cookie
        if (null != cookies && !cookies.isEmpty()) {
            connection.cookies(cookies);
        }
        Connection.Response response = connection.execute();
        FileOutputStream out = (new FileOutputStream(new File("D:\\imgs\\abc.gif")));
        out.write(response.bodyAsBytes());
        out.close();
        System.out.println("Captcha Fetched");
        return;
    }


//    public static getData(Map<String, String> paramsMap, Map<String, String> headerMap, Map<String, String> cookies) {
//
//    }
}
