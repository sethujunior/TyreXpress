/* Payment.java
   Payment Entity class
   Author: Bongikazi Mnyamana (222718404)*/

package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private final String paymentID;

    @Column(name = "amount")
    private final double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "method")
    private final PaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private final PaymentStatus status;

    @Column(name = "order_id")
    private final String orderID;

    protected Payment() {
        this.paymentID = null;
        this.amount = 0;
        this.method = null;
        this.status = null;
        this.orderID = null;
    }

    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.amount    = builder.amount;
        this.method    = builder.method;
        this.status    = builder.status;
        this.orderID   = builder.orderID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getOrderID() {
        return orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment that = (Payment) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(paymentID, that.paymentID) &&
                method == that.method &&
                status == that.status &&
                Objects.equals(orderID, that.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, amount, method, status, orderID);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", method=" + method +
                ", status=" + status +
                ", orderID='" + orderID + '\'' +
                '}';
    }

    public static class Builder {

        private String paymentID;
        private double amount;
        private PaymentMethod method;
        private PaymentStatus status;
        private String orderID;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setMethod(PaymentMethod method) {
            this.method = method;
            return this;
        }

        public Builder setStatus(PaymentStatus status) {
            this.status = status;
            return this;
        }

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentID = payment.paymentID;
            this.amount    = payment.amount;
            this.method    = payment.method;
            this.status    = payment.status;
            this.orderID   = payment.orderID;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}