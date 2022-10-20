package org.training.ms.etiya.msaccounting.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.training.ms.etiya.msaccountingapi.IPaymentProcessController;
import org.training.ms.etiya.msaccountingapi.models.PaymentRequest;
import org.training.ms.etiya.msaccountingapi.models.PaymentResult;

@RestController
public class PaymentProcessController implements IPaymentProcessController {
    @Value("${server.port}")
    private int port;

    private int counter = 0;

    @Override
    public PaymentResult pay(PaymentRequest request) {
        counter++;
        if (counter % 3 == 0){
            throw new IllegalArgumentException("test exp");
        }
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setCustomerId(101L);
        paymentResult.setAmount(request.getAmount());
        paymentResult.setDesc("Ödendi port : " + port);
        return paymentResult;
    }
}
