package batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

public class BuUp {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/fdt/Desktop/工作簿4.csv"));
        String sql = "UPDATE TRADE_REPORT_trader SET ROUTE = '%s'  WHERE GROUP_ID = '%s' AND LTS_ACCOUNT_ID = '%s' AND TRADE_DATE = '%s' AND ROUTE != '%s';";
        Object[] objects = reader.lines().toArray();
        for (int i = 0; i < objects.length; i++) {
            String s = objects[i].toString();
            String[] split = s.split(",");
            System.out.println(String.format(sql, split[0], split[1],  split[2], "2018-03-09", split[0]));
        }
    }
}
