package util.https;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public static String doHttpsGet(String url, Map<String, String> params, Map<String, String> headerMap, String cookies) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
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
        if("" != cookies){
            httpsConn.setRequestProperty("Cookie", cookies);
        }
        httpsConn.setRequestMethod("GET");
        httpsConn.connect();
        //获取cookie,供下次访问时使用
        //取cookie
        cookieVal = httpsConn.getHeaderField("set-cookie");
        System.out.println("====================cookie:" + cookieVal + "================================");

        in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), "utf-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if (in != null) {
            in.close();
        }
        return result;
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
    public static Map<String, String> doHttpsPost(String url, String data, Map<String, String> headerMap, String cookies) throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, IOException {
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
        if("" != cookies){
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
        System.out.println("====================cookie:" + cookieVal + "================================");
//        return buffer.toString();
        Map<String, String> result = new HashMap<String, String>();
        result.put("out", buffer.toString());
        result.put("cookies", cookieVal);
        return result;
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
            String value = entry.getKey();
            list.add(new BasicNameValuePair(key, value));
        }

        String requestParam = URLEncodedUtils.format(list, "UTF-8");
        return requestParam;
    }
}
