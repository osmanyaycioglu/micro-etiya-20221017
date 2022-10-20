package org.training.ms.etiya.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import org.training.ms.etiya.microservice.common.error.ErrorClientConfig;
import org.training.ms.etiya.microservice.common.error.ErrorConfig;

@SpringBootApplication(scanBasePackages = {"org.training.ms.etiya.msorder","org.training.microservice.resilience"})
@EnableEurekaClient
@EnableFeignClients
@Import({ErrorConfig.class,
         ErrorClientConfig.class
})
public class MsOrderApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
