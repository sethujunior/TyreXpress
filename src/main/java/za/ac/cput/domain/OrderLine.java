package za.ac.cput.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "order_lines")
public class OrderLine {
    @Id
    private Long orderLineId;
    private int quantity;
    private double unitPrice;
    private double lineTotal;
    private String productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderLine(){

    }
    public OrderLine(Builder builder){
        this.orderLineId = builder.orderLineId;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.lineTotal = builder.lineTotal;
        this.productId = builder.productId;
    }

    public Long getOrderLineId() {
        return orderLineId;
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
        return productId;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineID='" + orderLineId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", lineTotal=" + lineTotal +
                ", productID='" + productId + '\'' +
                '}';
    }
    public static class Builder{
        private Long orderLineId;
        private int quantity;
        private double unitPrice;
        private double lineTotal;
        private String productId;

        public Builder setOrderLineId(Long orderLineID) {
            this.orderLineId = orderLineId;
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

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }
        public Builder copy(OrderLine orderLine){
            this.orderLineId = orderLine.orderLineId;
            this.quantity = orderLine.quantity;
            this.unitPrice = orderLine.unitPrice;
            this.lineTotal = orderLine.lineTotal;
            this.productId = orderLine.productId;
            return this;
        }
        public OrderLine build(){
            return new OrderLine(this);
        }
    }
}
