package util.https;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 实现X509TrustManager
 * 重写信任管理器，不检查证书
 *
 * @author: qidima
 * @date: 2018/1/12
 * Time: 15:00
 */
public class BZX509TrustManager implements X509TrustManager {

    public BZX509TrustManager() {
    }

    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
//        return new X509Certificate[0];
    }

    /**
     * 重写ssF工厂类，引入无需检验证书的BZX509TrustManager
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    public static SSLSocketFactory getSSFactory() throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        TrustManager[] tm = { new BZX509TrustManager()};
//        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tm, new java.security.SecureRandom());
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        return  ssf;
    }
}
