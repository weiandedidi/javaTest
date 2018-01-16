package util.https;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
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

    public static Map<String,String> postData(String url, Map<String, String> paramsMap, Map<String, String> headerMap, Map<String, String> cookies) throws IOException {
        Connection conn = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                //not neccesary but these extra headers won't hurt
                .timeout(0)
                .method(Connection.Method.POST);
        if (null != cookies && !cookies.isEmpty()) {
            conn.cookies(cookies);
        }
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            conn.header(entry.getKey(), entry.getValue());
        }
        conn.data(paramsMap);
        Connection.Response response = conn.execute();
        Map<String, String> backCookies = response.cookies();
        System.out.println(backCookies);
        Document doc = response.parse();
        FileWriter fr = new FileWriter("D:\\imgs\\post.html");
        PrintWriter pw = new PrintWriter(fr);
        pw.println(doc.toString());
//        System.out.println(doc.toString());
        pw.close();
        fr.close();
        return backCookies;
    }



    public static Map<String,String> getData(String url, Map<String, String> headerMap, Map<String, String> cookies) throws IOException {
        Connection conn = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                //not neccesary but these extra headers won't hurt
                .timeout(0)
                .method(Connection.Method.GET);
        if (null != cookies && !cookies.isEmpty()) {
            conn.cookies(cookies);
        }
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            conn.header(entry.getKey(), entry.getValue());
        }
        Connection.Response response = conn.execute();
        Map<String, String> backCookies = response.cookies();
        System.out.println(response.cookies());
        Document doc = response.parse();
        FileWriter fr = new FileWriter("D:\\imgs\\get.html");
        PrintWriter pw = new PrintWriter(fr);
        pw.println(doc.toString());
//        System.out.println(doc.toString());
        pw.close();
        fr.close();
        return backCookies;
    }



}
