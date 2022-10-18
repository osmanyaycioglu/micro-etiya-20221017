package org.training.ms.etiya.springdemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Scope("prototype")
public class HelloEng {

    public HelloEng() {
        System.out.println("Hello Eng yaratıldı");
    }

    public String hello(String name){
        return "Hello " + name;
    }

}
