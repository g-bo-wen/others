package pk;

import java.text.ParseException;
import java.util.Date;

public class Order {
    private String beginId;
    private String endId;
    private Date begin;
    private Date end;


    public String getBeginId() {
        return beginId;
    }

    public void setBeginId(String beginId) {
        this.beginId = beginId;
        try {
            begin = Utils.format.parse(beginId.substring(3, beginId.length() - 6));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId;
        try {
            end = Utils.format.parse(endId.substring(3, endId.length() - 6));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getBegin() {
        return begin;
    }


    public Date getEnd() {
        return end;
    }
}
