package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    private static PaymentRepository repository = null;
    private final List<Payment> paymentList;

    private PaymentRepository() {
        paymentList = new ArrayList<>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    public Payment create(Payment payment) {
        boolean success = paymentList.add(payment);
        if (success) return payment;
        return null;
    }

    public Payment read(String paymentID) {
        for (Payment payment : paymentList) {
            if (payment.getPaymentID().equals(paymentID)) {
                return payment;
            }
        }
        return null;
    }

    public Payment update(Payment payment) {
        String id = payment.getPaymentID();
        Payment oldPayment = read(id);
        if (oldPayment == null) return null;
        boolean success = paymentList.remove(oldPayment);
        if (!success) return payment;
        if (paymentList.add(payment)) return payment;
        return null;
    }

    public boolean delete(String paymentID) {
        Payment paymentToDelete = read(paymentID);
        if (paymentToDelete == null) return false;
        return paymentList.remove(paymentToDelete);
    }

    public List<Payment> getAll() {
        return new ArrayList<>(paymentList);
    }
}