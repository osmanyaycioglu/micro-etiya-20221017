package org.training.ms.etiya.msorder.services.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.training.ms.etiya.microservice.common.error.RestErrorObj;
import org.training.ms.etiya.msaccountingapi.models.PaymentRequest;
import org.training.ms.etiya.msaccountingapi.models.PaymentResult;
import org.training.ms.etiya.msorder.services.models.Order;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountingIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private IAccountingIntegration accountingIntegration;

    private AtomicLong roundRobinIndex = new AtomicLong();

    @Retry(name = "myAccountRetry")
    public String paymentRequest3(Order order,
                                 BigDecimal amount) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(amount);
        paymentRequest.setOrderId(order.getOrderId());
        paymentRequest.setCustomerNumber(order.getCustomerNumber());
        PaymentResult paymentResult = accountingIntegration.pay(paymentRequest);
        return paymentResult.getDesc() + " " + paymentResult.getAmount() + " customer : " + paymentResult.getCustomerId();
    }


    public String paymentRequest(Order order,
                                 BigDecimal amount) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(amount);
        paymentRequest.setOrderId(order.getOrderId());
        paymentRequest.setCustomerNumber(order.getCustomerNumber());

        PaymentResult paymentResult = null;
        try {
            paymentResult = restTemplate.postForObject("http://ACCOUNTING/api/v1/payment/process/pay",
                                                                     paymentRequest,
                                                                     PaymentResult.class);
        } catch (RestClientResponseException e) {
            String err = e.getResponseBodyAsString();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                RestErrorObj restErrorObj = objectMapper.readValue(e.getResponseBodyAsByteArray(),
                                                                   RestErrorObj.class);
            } catch (Exception ex) {
            }
            throw e;
        }
        return paymentResult.getDesc() + " " + paymentResult.getAmount() + " customer : " + paymentResult.getCustomerId();
    }


    public String paymentRequest2(Order order,
                                  BigDecimal amount) {
        long index = roundRobinIndex.incrementAndGet();
        Application application = eurekaClient.getApplication("ACCOUNTING");
        List<InstanceInfo> instances = application.getInstances();
        if (instances != null && !instances.isEmpty()) {
            RestTemplate template = new RestTemplate();
            InstanceInfo instanceInfo = instances.get((int) index % instances.size());
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setAmount(amount);
            paymentRequest.setOrderId(order.getOrderId());
            paymentRequest.setCustomerNumber(order.getCustomerNumber());
            PaymentResult paymentResult = template.postForObject("http://"
                                                                         + instanceInfo.getIPAddr()
                                                                         + ":" +
                                                                         instanceInfo.getPort()
                                                                         + "/api/v1/payment/process/pay",
                                                                 paymentRequest,
                                                                 PaymentResult.class);
            return paymentResult.getDesc() + " " + paymentResult.getAmount() + " customer : " + paymentResult.getCustomerId();
        }
        return "Başarısız";
    }


}
