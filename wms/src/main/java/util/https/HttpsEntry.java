package util.https;

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
     * 返回的cookies
     */
    private String cookies;

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
}
