package pk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class time {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS");
        Date parse = format.parse("20180307-102021-451");
        Date parse1 = format.parse("20180307-102021-462");
        System.out.println(parse.before(parse1));
        System.out.println(parse.after(parse1));
    }
}
