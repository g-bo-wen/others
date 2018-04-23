package json;

public class Data {
    private Integer orderType;
    private String symbol;
    private Integer side;
    private String quoteSize;
    private String executedValue;
    private Integer source;
    private String userId;
    private Long modifyTime;
    private String size;
    private Long createTime;
    private String filledSize;
    private String price;
    private Integer systemType;
    private Long id;
    private Integer status;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public String getQuoteSize() {
        return quoteSize;
    }

    public void setQuoteSize(String quoteSize) {
        this.quoteSize = quoteSize;
    }

    public String getExecutedValue() {
        return executedValue;
    }

    public void setExecutedValue(String executedValue) {
        this.executedValue = executedValue;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getFilledSize() {
        return filledSize;
    }

    public void setFilledSize(String filledSize) {
        this.filledSize = filledSize;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Data{" +
                "orderType=" + orderType +
                ", symbol='" + symbol + '\'' +
                ", side=" + side +
                ", quoteSize='" + quoteSize + '\'' +
                ", executedValue='" + executedValue + '\'' +
                ", source=" + source +
                ", userId='" + userId + '\'' +
                ", modifyTime=" + modifyTime +
                ", size='" + size + '\'' +
                ", createTime=" + createTime +
                ", filledSize='" + filledSize + '\'' +
                ", price='" + price + '\'' +
                ", systemType=" + systemType +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
