package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private static IOrderRepository repository = null;
    private final List<Order> orderList;

    private OrderRepository() {
        orderList = new ArrayList<>();
    }

    public static IOrderRepository getRepository() {
        if (repository == null) {
            repository = new OrderRepository();
        }
        return repository;
    }
    @Override
    public Order create(Order order) {
        boolean success = orderList.add(order);
        if (success) {
            return order;
        }
        return null;
    }
    @Override
    public Order read(Long orderId) {
        for(Order order:orderList){
            if(order.getOrderId().equals(orderId)){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        Long id = order.getOrderId();
        Order oldOrder = read(id);

        if(oldOrder == null){
            return null;
        }
        boolean success = orderList.remove(oldOrder);
        if(!success){
            return order;
        }
        if (orderList.add(order)) {
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(Long orderId) {
        Order orderToDelete = read(orderId);
        if(orderToDelete == null){
            return false;
        }
        return orderList.remove(orderToDelete);
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }
}

