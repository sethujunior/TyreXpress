package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderStatus;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    private IOrderRepository repository;
    @BeforeEach
    void Setup() { repository = OrderRepository.getRepository();
    }

    @Test
    void create() {
        Order order = OrderFactory.createOrder(
                11L,
                1500.00,
                LocalDate.now(),
                OrderStatus.PENDING,
                "1",
                "A1",
                "P1"
        );
        Order created = repository.create(order);
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Order order = OrderFactory.createOrder(
                11L,
                1500.00,
                LocalDate.now(),
                OrderStatus.PENDING,
                "1",
                "A1",
                "P1"
        );
        repository.create(order);
        Order read = repository.read(11L);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Order order = OrderFactory.createOrder(
                11L,
                1500.00,
                LocalDate.now(),
                OrderStatus.PENDING,
                "1",
                "A1",
                "P1"
        );
        repository.create(order);

        Order updated = new Order.Builder().copy(order).
                setStatus(OrderStatus.DELIVERED).build();

        Order result = repository.update(updated);
        System.out.println("Update: " + updated);

    }

    @Test
    void delete() {
        Order order = OrderFactory.createOrder(
                11L,
                1500.00,
                LocalDate.now(),
                OrderStatus.PENDING,
                "1",
                "A1",
                "P1"
        );
        repository.create(order);
        boolean delete = repository.delete(11L);
        System.out.println("Delete: " + delete);
    }

    @Test
    void getAll() {
        Order order = OrderFactory.createOrder(
                11L,
                1500.00,
                LocalDate.now(),
                OrderStatus.PENDING,
                "1",
                "A1",
                "P1"
        );
        repository.create(order);
        System.out.println("All orders: " + repository.getAll());
    }
    }