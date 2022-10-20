package org.training.ms.etiya.msnotification;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.DIRECT),
            key = "sms-send"
    ))
    public void handleSMS(String message){
        System.out.println("Sending SMS : " + message);
    }

}
