/* PaymentRepositoryTest.java
   Payment Repository Test class
   Author: Bongikazi Mnyamana (222718404)
   Date: 22 August 2026 */

package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;
import za.ac.cput.factory.PaymentFactory;

@DataJpaTest
class PaymentRepositoryTest {

    @Autowired
    private IPaymentRepository repository;

    @Test
    void testCreate() {
        Payment payment = PaymentFactory.buildPayment(
                00l,
                1500.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-001"
        );
        Payment created = repository.save(payment);
        System.out.println("Created: " + created);
    }

    @Test
    void testRead() {
        Payment payment = PaymentFactory.buildPayment(
                002l,
                500.00,
                PaymentMethod.EFT,
                PaymentStatus.PENDING,
                "order-002"
        );
        repository.save(payment);
        Payment read = repository.findById(002l).orElse(null);
        System.out.println("Read: " + read);
    }

    @Test
    void testUpdate() {
        Payment payment = PaymentFactory.buildPayment(
                003l,
                750.00,
                PaymentMethod.CASH,
                PaymentStatus.PENDING,
                "order-003"
        );
        repository.save(payment);

        Payment updated = new Payment.Builder()
                .copy(payment)
                .setStatus(PaymentStatus.PAID)
                .build();

        Payment result = repository.save(updated);
        System.out.println("Updated: " + result);
    }

    @Test
    void testDelete() {
        Payment payment = PaymentFactory.buildPayment(
                004l,
                250.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-004"
        );
        repository.save(payment);
        repository.deleteById(004l);
        System.out.println("Deleted: true");
    }

    @Test
    void testGetAll() {
        Payment payment = PaymentFactory.buildPayment(
                005l,
                999.00,
                PaymentMethod.EFT,
                PaymentStatus.PAID,
                "order-005"
        );
        repository.save(payment);
        System.out.println("All payments: " + repository.findAll());
    }
}