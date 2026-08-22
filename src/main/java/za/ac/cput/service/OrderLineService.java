package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.repository.IOrderLineRepository;
import za.ac.cput.repository.OrderLineRepository;
import za.ac.cput.repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineService implements IOrderLineService{

    private static OrderLineService service = null;
    private IOrderLineRepository repository;

    private OrderLineService() {
        repository = OrderLineRepository.getRepository();
    }


    public static OrderLineService getService() {
        if (service == null) {
            service = new OrderLineService();
        }
        return service;
    }
    @Override
    public OrderLine create(OrderLine orderLine) {
        return repository.create(orderLine);
    }

    @Override
    public OrderLine read(Long orderLineId) {
        return repository.read(orderLineId);
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return repository.update(orderLine);
    }

    @Override
    public boolean delete(Long orderLineId) {
        return repository.delete(orderLineId);
    }

    @Override
    public List<OrderLine> getAll() {
        return repository.getAll();
    }
}
