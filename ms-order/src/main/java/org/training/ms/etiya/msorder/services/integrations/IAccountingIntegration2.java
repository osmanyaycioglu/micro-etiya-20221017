package org.training.ms.etiya.msorder.services.integrations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.ms.etiya.msaccountingapi.models.PaymentRequest;
import org.training.ms.etiya.msaccountingapi.models.PaymentResult;

public interface IAccountingIntegration2 {

    @PostMapping("/api/v1/payment/processor/pay")
    PaymentResult payMe(@RequestBody PaymentRequest paymentRequest);

}
