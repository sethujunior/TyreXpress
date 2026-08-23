package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.repository.IOrderLineRepository;

import java.util.List;

@Service
public class OrderLineService implements IOrderLineService{

    private IOrderLineRepository repository;
    public OrderLineService(IOrderLineRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public OrderLine read(Long orderLineId) {
        return repository.findById(orderLineId).orElse(null);
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public boolean delete(Long orderLineId) {
        OrderLine orderLine = repository.findById(orderLineId).orElse(null);
        if (orderLine != null) {
            repository.delete(orderLine);
        }
        return repository.existsById(orderLineId);
    }

    @Override
    public List<OrderLine> getAll() {
        return repository.findAll();
    }
}
