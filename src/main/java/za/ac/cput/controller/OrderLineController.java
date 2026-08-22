package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.service.IOrderLineService;
import za.ac.cput.service.IOrderService;
import za.ac.cput.service.OrderLineService;
import za.ac.cput.service.OrderService;

import java.util.List;
@RestController
@RequestMapping("/orderLine")
public class OrderLineController {
    private static OrderLineController controller = null;
    private IOrderLineService service;

    public OrderLineController(OrderLineService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public OrderLine create(@RequestBody OrderLine orderLine) {
        return service.create(orderLine);
    }

    @GetMapping("/read/{id}")
    public OrderLine read(@PathVariable Long orderlineId) {
        return service.read(orderlineId);
    }

    @PutMapping("/update")
    public OrderLine update(@RequestBody OrderLine orderLine) {
        return service.update(orderLine);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long orderLineId) {
        return service.delete(orderLineId);
    }

    @GetMapping("/getAll")
    public List<OrderLine> getAll() {
        return service.getAll();
    }
}

