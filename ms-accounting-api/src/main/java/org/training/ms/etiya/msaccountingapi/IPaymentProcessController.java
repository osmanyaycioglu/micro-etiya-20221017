package org.training.ms.etiya.msaccountingapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.ms.etiya.msaccountingapi.models.PaymentRequest;
import org.training.ms.etiya.msaccountingapi.models.PaymentResult;

public interface IPaymentProcessController {

    @PostMapping("/api/v1/payment/process/pay")
    PaymentResult pay(@RequestBody PaymentRequest request);

}
