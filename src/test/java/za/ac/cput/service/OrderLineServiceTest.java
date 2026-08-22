package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.OrderLineFatcory;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineServiceTest {
    private OrderLineService service;

    @BeforeEach
    void SetUp() { service = OrderLineService.getService();}

    @Test
    void create() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                "OL1",
                2,
                250.00,
                500.00,
                "P1"
        );
        OrderLine created = service.create(orderLine);
        System.out.println("Created: " + orderLine);
    }

    @Test
    void read() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                "OL1",
                2,
                250.00,
                500.00,
                "P1"
        );
        service.create(orderLine);
        OrderLine read = service.read("OL1");
        System.out.println("Read: " + read);

    }

    @Test
    void update() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                "OL1",
                2,
                250.00,
                500.00,
                "P1"
        );
        service.create(orderLine);

        OrderLine updated = new OrderLine.Builder().copy(orderLine).
                setUnitPrice(270.00).build();

        OrderLine result = service.update(updated);
        System.out.println("Updated: " + result);
    }

    @Test
    void delete() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                "OL1",
                2,
                250.00,
                500.00,
                "P1"
        );
        service.create(orderLine);

        boolean delete = service.delete("OL1");
        System.out.println("Delete: " + delete);

    }

    @Test
    void getAll() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                "OL1",
                2,
                250.00,
                500.00,
                "P1"
        );
        service.create(orderLine);
        System.out.println("All payments: " + service.getAll());

    }
}