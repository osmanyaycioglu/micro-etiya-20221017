package org.training.ms.etiya.msorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.ms.etiya.msorder.services.db.OrderDbService;
import org.training.ms.etiya.msorder.services.models.Order;

import java.util.List;

@Service
public class OrderQueryService {
    @Autowired
    private OrderDbService orderDbService;

    public Order getOne(Long orderId) {
        return orderDbService.getOne(orderId);
    }

    public List<Order> getAll() {
        return orderDbService.getAll();
    }

    public List<Order> getActiveOrders() {
        return orderDbService.getActiveOrders();
    }

    public List<Order> getOrderByNumber(String number) {
        return orderDbService.getOrderByNumber(number);
    }
}
