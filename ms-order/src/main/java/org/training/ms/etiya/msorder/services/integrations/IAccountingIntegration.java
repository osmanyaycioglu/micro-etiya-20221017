package org.training.ms.etiya.msorder.services.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.training.ms.etiya.msaccountingapi.IPaymentProcessController;

@FeignClient(value = "APIGW-ACCOUNTING",contextId = "accountInt1")
public interface IAccountingIntegration extends IPaymentProcessController {

}
