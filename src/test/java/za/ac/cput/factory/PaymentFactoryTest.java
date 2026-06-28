/* PaymentFactoryTest.java
   Payment Factory Test class
   Author: Bongikazi Mnyamana (222718404)
   Date: 28 June 2026 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void testSuccessfulCreation() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-001",
                1500.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-001"
        );
        assertNotNull(payment);
        assertEquals("PAY-001", payment.getPaymentID());
        assertEquals(1500.00, payment.getAmount());
        assertEquals(PaymentMethod.CARD, payment.getMethod());
        assertEquals(PaymentStatus.PAID, payment.getStatus());
        assertEquals("order-001", payment.getOrderID());
    }

    @Test
    void testNullPaymentIDReturnsNull() {
        Payment payment = PaymentFactory.buildPayment(
                null,
                1500.00,
                PaymentMethod.CARD,
                PaymentStatus.PAID,
                "order-001"
        );
        assertNull(payment);
    }

    @Test
    void testInvalidAmountReturnsNull() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-002",
                0,
                PaymentMethod.EFT,
                PaymentStatus.PENDING,
                "order-002"
        );
        assertNull(payment);
    }

    @Test
    void testNullMethodReturnsNull() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-003",
                500.00,
                null,
                PaymentStatus.PENDING,
                "order-003"
        );
        assertNull(payment);
    }

    @Test
    void testNullStatusReturnsNull() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-004",
                500.00,
                PaymentMethod.CASH,
                null,
                "order-004"
        );
        assertNull(payment);
    }

    @Test
    void testEmptyOrderIDReturnsNull() {
        Payment payment = PaymentFactory.buildPayment(
                "PAY-005",
                500.00,
                PaymentMethod.CASH,
                PaymentStatus.PENDING,
                ""
        );
        assertNull(payment);
    }
}