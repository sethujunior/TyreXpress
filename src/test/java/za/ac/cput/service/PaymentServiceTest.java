/* PaymentServiceTest.java
   Payment Service Test class
   Author: Bongikazi Mnyamana (222718404)*/

package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;
import za.ac.cput.factory.PaymentFactory;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    @Test
    void testCreate() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-001",
                1500.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-001"
        );
        Payment created = service.create(payment);
        System.out.println("Created: " + created);
    }

    @Test
    void testRead() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-002",
                500.00,
                PaymentMethod.EFT,
                PaymentStatus.PENDING,
                "order-002"
        );
        service.create(payment);
        Payment read = service.read("PAY-002");
        System.out.println("Read: " + read);
    }

    @Test
    void testUpdate() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-003",
                750.00,
                PaymentMethod.CASH,
                PaymentStatus.PENDING,
                "order-003"
        );
        service.create(payment);
        Payment updated = new Payment.Builder()
                .copy(payment)
                .setStatus(PaymentStatus.PAID)
                .build();
        Payment result = service.update(updated);
        System.out.println("Updated: " + result);
    }

    @Test
    void testDelete() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-004",
                250.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-004"
        );
        service.create(payment);
        boolean deleted = service.delete("PAY-004");
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void testGetAll() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-005",
                999.00,
                PaymentMethod.EFT,
                PaymentStatus.PAID,
                "order-005"
        );
        service.create(payment);
        System.out.println("All payments: " + service.getAll());
    }
}