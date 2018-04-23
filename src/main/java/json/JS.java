package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JS {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String xml = "[{\"binary\":0,\"channel\":\"ok_sub_spot_etc_btc_order\",\"data\":{\"symbol\":\"etc_btc\",\"orderId\":338592555,\"unTrade\":\"0.0\",\"tradeUnitPrice\":\"0.00234921\",\"tradeAmount\":\"0.01000000\",\"createdDate\":\"1520497551000\",\"completedTradeAmount\":\"0.01000000\",\"averagePrice\":\"0.00233700\",\"tradePrice\":\"0.00002337\",\"tradeType\":\"buy\",\"status\"" +
                ":2}}]";
        Object o = gson.fromJson(xml, new TypeToken<List<OrderResponse>>() {}.getType());
        System.out.println(o);
    }
}
