package util.https;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/1/12
 * Time: 11:50
 */
public class SSLClient {
        public static void main(String[] args) throws Exception {
            String httpsURL = "https://2sc.sohu.com";
            URL myUrl = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }

            br.close();
        }
}
