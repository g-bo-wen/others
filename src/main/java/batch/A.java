package batch;

import java.io.BufferedReader;
import java.io.FileReader;

public class A {
    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM TRADE_REPORT_SYMBOL WHERE TRADE_DATE = '%s' AND ROUTE = '%s' AND GROUP_ID = '%s' AND SYMBOL = '%s' AND POOL_QTY != %s;";

    }
}
