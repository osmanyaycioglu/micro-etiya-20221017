package org.training.ms.etiya.msorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.ms.etiya.msorder.services.db.OrderDbService;
import org.training.ms.etiya.msorder.services.models.Order;

@Service
public class OrderProcessService {

    @Autowired
    private OrderDbService orderDbService;

    public Long addOrder(Order order){
        Order order1 = orderDbService.insertOrder(order);
        return -order1.getOrderId();
    }

    public void cancelOrder(Long orderId) {
        orderDbService.cancelOrder(orderId);
    }

    public void pauseOrder(Long orderId) {
        orderDbService.pauseOrder(orderId);
    }
}
