package org.training.ms.etiya.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean("helloX")
    public HelloEng helloEngX(){
         return new HelloEng();
    }

    @Bean("helloY")
    public HelloEng helloEngY(){
        return new HelloEng();
    }

    @Bean("helloZ")
    public HelloEng helloEngZ(){
        return new HelloEng();
    }

}
