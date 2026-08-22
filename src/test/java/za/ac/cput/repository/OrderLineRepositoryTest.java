package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.factory.OrderLineFatcory;
import za.ac.cput.service.OrderLineService;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineRepositoryTest {
    private IOrderLineRepository repository;

    @BeforeEach
    void SetUp() { repository = OrderLineRepository.getRepository();}

    @Test
    void create() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                1L,
                2,
                250.00,
                500.00,
                "P1"
        );
        OrderLine created = repository.create(orderLine);
        System.out.println("Created: " + orderLine);
    }

    @Test
    void read() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                1L,
                2,
                250.00,
                500.00,
                "P1"
        );
        repository.create(orderLine);
        OrderLine read = repository.read(1L);
        System.out.println("Read: " + read);

    }

    @Test
    void update() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                1L,
                2,
                250.00,
                500.00,
                "P1"
        );
        repository.create(orderLine);

        OrderLine updated = new OrderLine.Builder().copy(orderLine).
                setUnitPrice(270.00).build();

        OrderLine result = repository.update(updated);
        System.out.println("Updated: " + result);
    }

    @Test
    void delete() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                1L,
                2,
                250.00,
                500.00,
                "P1"
        );
        repository.create(orderLine);

        boolean delete = repository.delete(1L);
        System.out.println("Delete: " + delete);

    }

    @Test
    void getAll() {
        OrderLine orderLine = OrderLineFatcory.createOrderLine(
                1L,
                2,
                250.00,
                500.00,
                "P1"
        );
        repository.create(orderLine);
        System.out.println("All payments: " + repository.getAll());

    }
}