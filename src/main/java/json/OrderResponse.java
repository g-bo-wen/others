package json;

public class OrderResponse extends BaseResponse {
    private String base;
    private Data data;
    private String product;
    private String quote;
    private String type;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "base='" + base + '\'' +
                ", data=" + data +
                ", product='" + product + '\'' +
                ", quote='" + quote + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
