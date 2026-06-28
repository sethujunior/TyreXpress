/* PaymentFactory.java
   Payment Factory class
   Author: Bongikazi Mnyamana (222718404)
   Date: 27 June 2026 */

package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;
import za.ac.cput.util.Helper;

public class PaymentFactory {

    public static Payment buildPayment(String paymentID,
                                       double amount,
                                       PaymentMethod method,
                                       PaymentStatus status,
                                       String orderID) {

        if (Helper.isNullOrEmpty(paymentID)) {
            System.out.println("Payment ID cannot be null or empty");
            return null;
        }
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return null;
        }
        if (method == null) {
            System.out.println("Payment method cannot be null");
            return null;
        }
        if (status == null) {
            System.out.println("Payment status cannot be null");
            return null;
        }
        if (Helper.isNullOrEmpty(orderID)) {
            System.out.println("Order ID cannot be null or empty");
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setMethod(method)
                .setStatus(status)
                .setOrderID(orderID)
                .build();
    }
}