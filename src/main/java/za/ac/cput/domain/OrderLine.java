package za.ac.cput.domain;

public class OrderLine {
    private String orderLineID;
    private int quantity;
    private double unitPrice;
    private double lineTotal;
    private String productID;

    public OrderLine(){

    }
    public OrderLine(Builder builder){
        this.orderLineID = builder.orderLineID;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.lineTotal = builder.lineTotal;
        this.productID = builder.productID;
    }

    public String getOrderLineID() {
        return orderLineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    public String getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineID='" + orderLineID + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", lineTotal=" + lineTotal +
                ", productID='" + productID + '\'' +
                '}';
    }
    public static class Builder{
        private String orderLineID;
        private int quantity;
        private double unitPrice;
        private double lineTotal;
        private String productID;

        public Builder setOrderLineID(String orderLineID) {
            this.orderLineID = orderLineID;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder setLineTotal(double lineTotal) {
            this.lineTotal = lineTotal;
            return this;
        }

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }
        public Builder copy(OrderLine orderLine){
            this.orderLineID = orderLine.orderLineID;
            this.quantity = orderLine.quantity;
            this.unitPrice = orderLine.unitPrice;
            this.lineTotal = orderLine.lineTotal;
            this.productID = orderLine.productID;
            return this;
        }
        public OrderLine build(){
            return new OrderLine(this);
        }
    }
}
