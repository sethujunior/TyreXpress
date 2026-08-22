package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Order;
import za.ac.cput.service.IOrderService;
import za.ac.cput.service.OrderService;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {
    private static OrderController controller = null;
    private IOrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/read/{id}")
    public Order read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Order> getAll() {
        return service.getAll();
    }
}

