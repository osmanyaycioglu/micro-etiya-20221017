package org.training.ms.etiya.msorder.services.integrations;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationIntegration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSMS(SendMessage sendMessage) {
        rabbitTemplate.convertAndSend("message-exchange",
                                      "sms-send",
                                      sendMessage);
    }

}
