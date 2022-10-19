package org.training.ms.etiya.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.training.ms.etiya.microservice.common.error.ErrorConfig;

@SpringBootApplication
@EnableEurekaClient
@Import({ErrorConfig.class})
public class MsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
