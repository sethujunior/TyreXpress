package za.ac.cput.repository;

import za.ac.cput.domain.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class OrderLineRepository implements IOrderLineRepository{
        private static IOrderLineRepository repository = null;
        private final List<OrderLine> orderLineList;

        private OrderLineRepository() {
            orderLineList = new ArrayList<>();
        }

    public static IOrderLineRepository getRepository() {
        if (repository == null) {
            repository = new OrderLineRepository();
        }
        return repository;
        }

    @Override
    public OrderLine create(OrderLine orderLine) {
        boolean success = orderLineList.add(orderLine);
        if (success) {
            return orderLine;
        }
        return null;
    }

    @Override
    public OrderLine read(Long orderLineId) {
        for(OrderLine orderLine:orderLineList){
            if(orderLine.getOrderLineId().equals(orderLineId)){
                return orderLine;
            }
        }
        return null;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        Long id = orderLine.getOrderLineId();
        OrderLine oldOrder = read(id);

        if(oldOrder == null){
            return null;
        }
        boolean success = orderLineList.remove(oldOrder);
        if(!success){
            return orderLine;
        }
        if (orderLineList.add(orderLine)) {
            return orderLine;
        }
        return null;
    }

    @Override
    public boolean delete(Long orderLineId) {
        OrderLine orderToDelete = read(orderLineId);
        if(orderToDelete == null){
            return false;
        }
        return orderLineList.remove(orderToDelete);
    }

    @Override
        public List<OrderLine> getAll() {
            return orderLineList;
        }
    }

