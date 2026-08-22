/* PaymentControllerTest.java
   Payment Controller Test class
   Author: Bongikazi Mnyamana (222718404)
   Date: 15 July 2026 */

package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;
import za.ac.cput.factory.PaymentFactory;

@SpringBootTest
class PaymentControllerTest {

    @Autowired
    private PaymentController controller;

    @Test
    void testCreate() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-001",
                1500.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-001"
        );
        Payment created = controller.create(payment);
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
        controller.create(payment);
        Payment read = controller.read("PAY-002");
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
        controller.create(payment);
        Payment updated = new Payment.Builder()
                .copy(payment)
                .setStatus(PaymentStatus.PAID)
                .build();
        Payment result = controller.update(updated);
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
        controller.create(payment);
        boolean deleted = controller.delete("PAY-004");
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
        controller.create(payment);
        System.out.println("All: " + controller.getAll());
    }
}