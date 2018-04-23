package json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Con {
    public static void main(String[] args) {
        String str = "ok_sub_spot_etc_btc_order";
        String s = "ok_sub_spot_etc_btc_balance";
        Pattern pa = Pattern.compile("ok_sub_spot.+order");
        Matcher matcher = pa.matcher(s);
        System.out.println(str.contains("ok_sub_spot.+order"));
        System.out.println(matcher.matches());
    }
}
