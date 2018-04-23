package ok;

import okhttp3.*;

import java.io.IOException;

public class http {
    public static String url = "https://api.binance.com";

    public static void main(String[] args) throws Exception{
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        FormBody.Builder form = new FormBody.Builder();
        form = form.add("symbol", "LTCBTC");
        form = form.add("side", "BUY");
        form = form.add("type", "LIMIT");
        form = form.add("timeInForce", "GTC");
        form = form.add("quantity", "1");
        form = form.add("price", "0.1");
        form = form.add("recvWindow", "5000");
        form = form.add("timestamp", "1499827319559");
        form = form.add("signature", "c8db56825ae71d6d79447849e617115f4a920fa2acdcab2b053c4b2838bd6b71");
        Request request = new Request.Builder().url(url + "/api/v1/order").post(form.build()).
                addHeader("X-MBX-APIKEY", "vmPUZE6mv9SD5VNHk4HlWFsOr6aKE2zvsw0MuIgwCIPy6utIco14y7Ju91duEh8A").
                addHeader("Content-Type", "application/x-www-form-urlencoded").build();
        Response execute = builder.build().newCall(request).execute();
        System.out.println(execute.body().string());
    }
}
