package org.training.ms.etiya.microservice.common.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorClientConfig {

    @Bean
    public RestErrorDecoder restErrorDecoder(){
        return new RestErrorDecoder();
    }

}
