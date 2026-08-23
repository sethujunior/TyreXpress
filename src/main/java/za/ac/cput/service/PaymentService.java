/* PaymentService.java
   Payment Service Implementation
   Author: Bongikazi Mnyamana (222718404)*/
package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    private IPaymentRepository repository;

    public PaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(Long paymentId) {
        return repository.findById(paymentId).get();
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public boolean delete(Long paymentId) {
        repository.deleteById(paymentId);
        return true;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}