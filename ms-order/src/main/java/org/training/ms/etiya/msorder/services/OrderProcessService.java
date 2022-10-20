package org.training.ms.etiya.msorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.ms.etiya.msorder.services.db.OrderDbService;
import org.training.ms.etiya.msorder.services.integrations.AccountingIntegration;
import org.training.ms.etiya.msorder.services.integrations.NotificationIntegration;
import org.training.ms.etiya.msorder.services.integrations.SendMessage;
import org.training.ms.etiya.msorder.services.models.Order;

import java.math.BigDecimal;

@Service
public class OrderProcessService {

    @Autowired
    private OrderDbService orderDbService;

    @Autowired
    private AccountingIntegration accountingIntegration;

    @Autowired
    private NotificationIntegration notificationIntegration;

    @Transactional
    public String addOrder(Order order) {
        Order order1 = orderDbService.insertOrder(order);
        String s = accountingIntegration.paymentRequest(order,
                                                        BigDecimal.valueOf(100L));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setDest(order.getCustomerNumber());
        sendMessage.setMessage(s);

        notificationIntegration.sendSMS(sendMessage);
        return s;
    }

    public void cancelOrder(Long orderId) {
        orderDbService.cancelOrder(orderId);
    }

    public void pauseOrder(Long orderId) {
        orderDbService.pauseOrder(orderId);
    }

    public String addOrder2(Order order) {
        Order order1 = orderDbService.insertOrder(order);
        String s = accountingIntegration.paymentRequest2(order,
                                                        BigDecimal.valueOf(100L));
        return s;

    }
    public String addOrder3(Order order) {
        Order order1 = orderDbService.insertOrder(order);
        String s = accountingIntegration.paymentRequest3(order,
                                                         BigDecimal.valueOf(100L));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setDest(order.getCustomerNumber());
        sendMessage.setMessage(s);

        notificationIntegration.sendSMS(sendMessage);
        return s;

    }

}
