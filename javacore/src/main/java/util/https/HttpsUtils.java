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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (null != cookies && "" != cookies) {
            httpsConn.setRequestProperty("Cookie", cookies);
        }
        httpsConn.setRequestMethod("GET");
        httpsConn.connect();
        //设置接受编码,没有默认UTF-8
        String charset = "UTF-8";
        Pattern pattern = Pattern.compile("charset=\\S*");
        Matcher matcher = pattern.matcher(httpsConn.getContentType());
        if (matcher.find()) {
            charset = matcher.group().replace("charset=", "");
        }
        //获取返回的cookies
        String backCookies = getCookies(httpsConn);
        //处理html不能用bufferreader
        in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), charset));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if (in != null) {
            in.close();
        }
        HttpsEntry entry = new HttpsEntry();
        entry.setResult(result);
        entry.setCookies(backCookies);
        return entry;
    }

    /**
     * 通过https发送post请求,返回cookie
     * 只能用来post数据，返回json等格式，不能返回html
     * 因为html返回的东西可能有压缩，所以返回的不是简单<>拼装的字符串</>
     * bodyStream = res.hasHeaderWithValue("Content-Encoding", "gzip") ? new BufferedInputStream(new GZIPInputStream(dataStream)) : new BufferedInputStream(dataStream);
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
        if (null != cookies && "" != cookies) {
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
        if (out != null) {
            out.close();
        }

        //设置接受编码,没有默认UTF-8
        String charset = "UTF-8";
        Pattern pattern = Pattern.compile("charset=\\S*");
        Matcher matcher = pattern.matcher(httpsConn.getContentType());
        if (matcher.find()) {
            charset = matcher.group().replace("charset=", "");
        }

        //获取输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), charset));
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        if (reader != null) {
            reader.close();
        }
        //获取cookies
        String backCookies = getCookies(httpsConn);
        HttpsEntry entry = new HttpsEntry();
        entry.setResult(buffer.toString());
        entry.setCookies(backCookies);
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
     * 获取验证码，面向资源类的验证码
     * String url = "https://i0.hdslb.com/bfs/active/1f8aa6cd328fee1eaf61d1f59e40e97addc1aae8.gif"
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
        //获取cookies
        String backCookies = getCookies(httpsConn);
        entry.setCookies(backCookies);
        return entry;
    }

    public static String downloadCaptcha(String url, Map<String, String> headerMap, Map<String, String> cookies) throws Exception {
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
        HttpsEntry entry = new HttpsEntry();
        Map<String, String> map = response.cookies();
        StringBuilder cookieBack = new StringBuilder();
        for (Map.Entry<String, String> entryset : map.entrySet()) {
            cookieBack.append(entryset.getKey());
            cookieBack.append("=");
            cookieBack.append(entryset.getValue());
            cookieBack.append(";");
        }
        return cookieBack.toString();
    }

    /**
     * 获取返回的cookies
     *
     * @param httpsConn
     * @return
     */
    private static String getCookies(HttpsURLConnection httpsConn) {
        String key = null;
        StringBuilder resCookies = new StringBuilder();
        for (int i = 1; (key = httpsConn.getHeaderFieldKey(i)) != null; i++) {
            if (key.equalsIgnoreCase("set-cookie")) {
                String cookiePart = httpsConn.getHeaderField(i);
                cookiePart = cookiePart.substring(0, cookiePart.indexOf(";"));      //Set-Cookie:userinfo=0; path=/; domain=.iautos.cn; httponly  截取第一个;之前的东西
                resCookies.append(cookiePart);
                resCookies.append(";");
            }
        }
        return resCookies.toString();
    }

    /**
     * 将cookies封装成map
     *
     * @param cookies
     * @return
     */
    public static Map<String, String> packCookiesMap(String cookies) {
        if (null == cookies || "".equals(cookies)) {
            return null;
        }
        //截断；
        String[] strs = cookies.split(";");
        //根据=封装kv
        if (strs.length < 1) {
            return null;
        }
        Map<String, String> cookiesMap = new HashMap<String, String>();
        for (int i = 0; i < strs.length; i++) {
            String[] temp = strs[i].split("=");
            cookiesMap.put(temp[0], temp[1]);
        }
        return cookiesMap;
    }


}
