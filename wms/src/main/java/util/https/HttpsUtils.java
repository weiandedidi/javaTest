package util.https;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    /**
     * https的get方法
     *
     * @param url
     * @param params
     * @param headerMap
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    public static String doHttpsGet(String url, Map<String, String> params, Map<String, String> headerMap) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
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

        httpsConn.setRequestMethod("GET");
        httpsConn.connect();

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

    public static String doHttpsPost(String url, Map<String, String> params, Map<String, String> headerMap) throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        URL requestUrl;
        //查询地址
        if (null == url || "".equals(url)) {
            return null;
        }
        requestUrl = new URL(url);
        String requestParam = "";
        if (null != params && !params.isEmpty()) {
            requestParam = contactGetString(params);
            requestUrl = new URL(url + "?" + requestParam);
        }

        //设置SSL设置套接工厂
        HttpsURLConnection httpsConn = (HttpsURLConnection) requestUrl.openConnection();
        SSLSocketFactory sslSocketFactory = BZX509TrustManager.getSSFactory();
        httpsConn.setSSLSocketFactory(sslSocketFactory);
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpsConn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpsConn.setRequestMethod("POST");
        httpsConn.setDoOutput(true);
        httpsConn.setDoInput(true);
        httpsConn.setUseCaches(false);
        out = new PrintWriter(httpsConn.getOutputStream());
        out.print(requestParam);
        out.flush();
        if (out != null) {
            out.close();
        }
        //获取输入流
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
}
