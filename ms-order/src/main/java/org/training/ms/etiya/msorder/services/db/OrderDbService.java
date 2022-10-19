package org.training.ms.etiya.msorder.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.ms.etiya.msorder.services.db.dao.IOrderDao;
import org.training.ms.etiya.msorder.services.models.EOrderState;
import org.training.ms.etiya.msorder.services.models.Order;

import java.util.List;

@Service
public class OrderDbService {
    @Autowired
    private IOrderDao orderDao;

    public Order insertOrder(Order order) {
        return orderDao.save(order);
    }

    public void cancelOrder(Long orderId) {
        orderDao.updateStatus(orderId,
                              EOrderState.CANCELED);
    }

    public void pauseOrder(Long orderId) {
        orderDao.updateStatus(orderId,
                              EOrderState.PAUSED);
    }

    public Order getOne(Long orderId) {
        return orderDao.findById(orderId)
                       .orElse(null);
    }

    public List<Order> getAll() {
        return orderDao.findAll();
    }

    public List<Order> getActiveOrders() {
        return orderDao.findByOrderState(EOrderState.ACTIVE);
    }

    public List<Order> getOrderByNumber(String number) {
        return orderDao.findByCustomerNumber(number)
                ;
    }
}
