package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderStatus;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class OrderFactory {
    public static Order createOrder(Long orderId, double totalAmount, LocalDate date, OrderStatus status,
                                    String customerId, String addressId, String paymentId) {
        if (orderId == null || Helper.isNullOrEmpty(addressId) || Helper.isNullOrEmpty(paymentId)) {
            return null;
        }
        if (totalAmount <= 0) {
            System.out.println("Amount must be greater than zero");
            return null;
        }
        return new Order.Builder().setOrderId(orderId).setTotalAmount(totalAmount).setDate(date).setStatus(status).
                setCustomerId(customerId).setAddressId(addressId).setPaymentId(paymentId).build();
    }

}
