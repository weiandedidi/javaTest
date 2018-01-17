package util.https;

import java.util.HashMap;
import java.util.Map;

/**
 * https的结果实体类
 *
 * @author: qidima
 * @date: 2018/1/16
 * Time: 14:00
 */
public class HttpsEntry {
    /**
     * 返回结果
     */
    private String result;
    /**
     * 存放连接在一起的cookies
     */
    private String cookies;
    /**
     * 存放k-v形式的cookie
     */
    private Map cookiesMap;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public Map getCookiesMap() {
        return cookiesMap;
    }

    public void setCookiesMap(Map cookiesMap) {
        this.cookiesMap = cookiesMap;
    }
}
