package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderLine;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineFatcoryTest {
    @Test
    void createOrderLine() {

        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                1L,
                2,
                250.00,
                500.00,
                "P1"
        );

        System.out.println(orderLine);
    }

}