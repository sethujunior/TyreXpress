package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    private IOrderRepository repository;
    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order read(Long orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }

    @Override
    public boolean delete(Long orderId) {
        return repository.existsById(orderId);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}
