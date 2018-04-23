package Sign;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Build {
    public static String apiKey = "vmPUZE6mv9SD5VNHk4HlWFsOr6aKE2zvsw0MuIgwCIPy6utIco14y7Ju91duEh8A";
    public static String secretKey = "RzYtJB1Sv5uQqg6Tmfv3Wd1kGJI4BcY9hRd4oH1xATYJ4CoMcknMcmwfrJCb971k";

    public static void main(String[] args) throws Exception {
        String queryString = "symbol=LTCBTC&side=BUY&type=LIMIT&timeInForce=GTC&quantity=1&price=0.1&recvWindow=6000000&timestamp=1499827319559";

        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKey key = new SecretKeySpec(secretKey.getBytes("utf8"), "HMACSHA256");
        mac.init(key);
        byte[] aFinal = mac.doFinal(queryString.getBytes("utf8"));
        StringBuffer hexString = new StringBuffer();

        System.out.println(hexString.toString());
    }

    public static String sign(String str) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKey key = new SecretKeySpec(secretKey.getBytes("utf8"), "HMACSHA256");
        mac.init(key);
        byte[] aFinal = mac.doFinal(str.getBytes("utf8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < aFinal.length; i++) {
            String hex = Integer.toHexString(0xff & aFinal[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
