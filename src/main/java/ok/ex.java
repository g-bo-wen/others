package ok;

import Sign.Build;
import org.apache.commons.io.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class ex {
    public static void main(String[] args) throws Exception {
        String str = "timestamp=" + URLEncoder.encode(System.currentTimeMillis() + "", "utf8");
        String sign = Build.sign(str);
        URL u = new URL("https://api.binance.com/api/v3/openOrders?signature=" + URLEncoder.encode(sign, "utf8") + "&" + str);
        HttpURLConnection co = (HttpURLConnection) u.openConnection();
        co.setRequestProperty("X-MBX-APIKEY", "tckyDMA3VPCutMCwTbHE7WwFXzjWgUfuy0MDCoG8kC83QEo51wZRYuaSi6abTl3X");
        System.out.println(co.getHeaderFields());
        System.out.println(co.getResponseCode());
        System.out.println(co.getResponseMessage());
        System.out.println(IOUtils.toString(co.getInputStream(), "utf8"));
    }
}
