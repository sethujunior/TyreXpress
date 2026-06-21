package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private String orderID;
    private double totalAmount;
    private LocalDate date;
    private OrderStatus status;
    private String customerID;
    private String addressID;
    private String paymentID;

    // Composition → Order contains many OrderLines
    private List<OrderLine> orderLines;

    public Order() {

    }

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.totalAmount = builder.totalAmount;
        this.date = builder.date;
        this.status = builder.status;
        this.customerID = builder.customerID;
        this.addressID = builder.addressID;
        this.paymentID = builder.paymentID;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAddressID() {
        return addressID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", totalAmount=" + totalAmount +
                ", date=" + date +
                ", status=" + status +
                ", customerID='" + customerID + '\'' +
                ", addressID='" + addressID + '\'' +
                ", paymentID='" + paymentID + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }

    public static class Builder {
        private String orderID;
        private double totalAmount;
        private LocalDate date;
        private OrderStatus status;
        private String customerID;
        private String addressID;
        private String paymentID;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setStatus(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder copy(Order order) {
            this.orderID = order.orderID;
            this.totalAmount = order.totalAmount;
            this.date = order.date;
            this.status = order.status;
            this.customerID = order.customerID;
            this.addressID = order.addressID;
            this.paymentID = order.paymentID;
            return this;
        }
        public Order build(){
            return new Order(this);

        }
    }
}
