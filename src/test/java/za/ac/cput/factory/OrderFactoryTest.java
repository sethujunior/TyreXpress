package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderStatus;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {
    @Test
    void createOrder() {

        Order order = OrderFactory.createOrder(
                11L,
                1500.00,
                LocalDate.now(),
                OrderStatus.PENDING,
                "1",
                "A1",
                "P1"
        );

        System.out.println(order);
    }
}