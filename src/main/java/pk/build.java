package pk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class build {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/fdt/Project/study/zip/src/main/java/pk/a.txt"));
        String str = null;
        List<Order> ls = new ArrayList<>();
        while ((str = reader.readLine()) != null) {
            Order o = new Order();
            String[] split = str.split("_");
            o.setBeginId(split[0]);
            o.setEndId(split[1]);
            ls.add(o);
        }

        List<List<String>> open = new ArrayList<>();
        //S1-20180307-102021-451-1022E  S1-20180307-102333-018-1785E
        //S1-20180307-102021-462-0922E  S1-20180307-102333-018-1785E
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            Order o1 = ls.get(i);
            tmp.add(o1.getBeginId());
            tmp.add(o1.getEndId());
            if (i == ls.size() - 1) {

            } else {
                Order o2 = ls.get(i + 1);
                if (o1.getEnd().before(o2.getBegin())) {
                    open.add(tmp);
                    tmp = new ArrayList<>();
                }
            }
        }
        open.forEach(x -> {
            if (x.contains("S1-20180129-142514-765-1240E")) {
                for (int i = 0; i < x.size(); i++) {
                    System.out.print("'" + x.get(i) + "'" + ", ");
                }
            }

        });
    }
}
