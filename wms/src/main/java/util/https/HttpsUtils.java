package util.https;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/1/12
 * Time: 15:11
 */
public class HttpsUtils {

    public static String cookieVal = "";

    /**
     * https的get方法
     *
     * @param url
     * @param params
     * @param headerMap
     * @param cookies
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    public static HttpsEntry doHttpsGet(String url, Map<String, String> params, Map<String, String> headerMap, String cookies) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        // 请求结果
        BufferedReader in = null;
        String result = "";
        URL requestUrl;
        //查询地址
        if (null == url || "".equals(url)) {
            return null;
        }
        requestUrl = new URL(url);
        if (null != params && !params.isEmpty()) {
            String requestParam = contactGetString(params);
            requestUrl = new URL(url + "?" + requestParam);
        }
        //设置SSL设置套接工厂
        HttpsURLConnection httpsConn = (HttpsURLConnection) requestUrl.openConnection();
        SSLSocketFactory sslSocketFactory = BZX509TrustManager.getSSFactory();
        httpsConn.setSSLSocketFactory(sslSocketFactory);
        //设置消息头
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpsConn.setRequestProperty(entry.getKey(), entry.getValue());
        }

        //先设置cookie，在连接connect
        if ("" != cookies) {
            httpsConn.setRequestProperty("Cookie", cookies);
        }
        httpsConn.setRequestMethod("GET");
        httpsConn.connect();
        //获取cookie,供下次访问时使用
        cookieVal = httpsConn.getHeaderField("set-cookie");
        in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), "gbk"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if (in != null) {
            in.close();
        }
        HttpsEntry entry = new HttpsEntry();
        entry.setResult(result);
        entry.setCookies(cookieVal);
        return entry;
    }

    /**
     * 通过https发送post请求,返回cookie
     *
     * @param url
     * @param data      数据组装成string的data
     * @param headerMap
     * @param cookies
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static HttpsEntry doHttpsPost(String url, String data, Map<String, String> headerMap, String cookies) throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, IOException {
        StringBuffer buffer = new StringBuffer();
        URL requestUrl;
        //查询地址
        if (null == url || "".equals(url)) {
            return null;
        }
        requestUrl = new URL(url);

        //设置SSL设置套接工厂
        HttpsURLConnection httpsConn = (HttpsURLConnection) requestUrl.openConnection();
        //设置cookie，在传输数据前
        if ("" != cookies) {
            httpsConn.setRequestProperty("Cookie", cookies);
        }

        httpsConn.setRequestMethod("POST");
        httpsConn.setDoOutput(true);
        httpsConn.setDoInput(true);
        httpsConn.setUseCaches(false);
        SSLSocketFactory sslSocketFactory = BZX509TrustManager.getSSFactory();
        httpsConn.setSSLSocketFactory(sslSocketFactory);
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpsConn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        String outParams = "";
        if (null != data) {
            //设置参数
            outParams = data;
        }
        //设置传输数据
        OutputStream out = httpsConn.getOutputStream();
        // 注意编码格式，防止中文乱码
        out.write(outParams.getBytes("UTF-8"));
        out.flush();

        //关闭输出
        if (out != null) {
            out.close();
        }
        //获取输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), "utf-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        if (reader != null) {
            reader.close();
        }
        //获取cookie
        cookieVal = httpsConn.getHeaderField("set-cookie");
        HttpsEntry entry = new HttpsEntry();
        entry.setResult(buffer.toString());
        entry.setCookies(cookieVal);
        return entry;
    }

    /**
     * 将hashMap转为lsit键值对
     *
     * @param params
     * @return
     */
    public static String contactGetString(Map<String, String> params) {
        //键值对
        List<org.apache.http.NameValuePair> list = new ArrayList<org.apache.http.NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            list.add(new BasicNameValuePair(key, value));
        }

        String requestParam = URLEncodedUtils.format(list, "UTF-8");
        return requestParam;
    }

    /**
     * 获取验证码
     *
     * @param url
     * @param headerMap
     * @param cookies
     */
    public static HttpsEntry downloadImgsByUrl(String url, Map<String, String> headerMap, String cookies, String imageName, String imageType) throws Exception {
        // 请求结果
        InputStream input = null;
        URL uri;
        //查询地址
        if (null == url || "".equals(url)) {
            return null;
        }
        uri = new URL(url);
        //设置SSL设置套接工厂
        HttpsURLConnection httpsConn = (HttpsURLConnection) uri.openConnection();
        SSLSocketFactory sslSocketFactory = BZX509TrustManager.getSSFactory();
        httpsConn.setSSLSocketFactory(sslSocketFactory);
        //设置消息头
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpsConn.setRequestProperty(entry.getKey(), entry.getValue());
        }

        //先设置cookie，在连接connect
        if (null != cookies && "" != cookies) {
            httpsConn.setRequestProperty("Cookie", cookies);
        }
        httpsConn.setRequestMethod("GET");
        //超时5s
        httpsConn.setConnectTimeout(5 * 1000);
        httpsConn.connect();
        //获取cookie,供下次访问时使用
        //取cookie
        cookieVal = httpsConn.getHeaderField("set-cookie");
        System.out.println("====================cookie:" + cookieVal + "================================");

        input = httpsConn.getInputStream();
//        String path = "D:\\imgs\\" + imageName + System.currentTimeMillis()+".gif";
        String path = "/Users/qidima/Work/imgs/" + imageName + System.currentTimeMillis() + "." + imageType;
//        String path = "/Users/qidima/Work/imgs/" + imageName + System.currentTimeMillis();
        OutputStream out = new FileOutputStream(new File(path));
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] buf = new byte[1024];
        int length = 0;
        System.out.println("开始下载:" + url);
        while ((length = input.read(buf)) != -1) {
            out.write(buf, 0, length);
        }
        out.flush();
        input.close();
        out.close();
        HttpsEntry entry = new HttpsEntry();
        entry.setResult("");
        entry.setCookies(cookieVal);
        return entry;
    }

    public static void downloadCaptcha(String url, Map<String, String> headerMap, String cookies) throws Exception {
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
//        connection.cookie();
        Connection.Response response = connection.execute();
        FileOutputStream out = (new FileOutputStream(new File("D:\\imgs\\abc.gif")));
        out.write(response.bodyAsBytes());
        out.close();
        System.out.println("Captcha Fetched");
        return;
    }

}
