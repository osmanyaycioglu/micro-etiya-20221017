package org.training.ms.etiya.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDemoApplication implements ApplicationRunner {

    // @Autowired // field injection
    private HelloEng helloEng1;
    private String   str;

    @Qualifier("helloX")
    @Autowired
    private HelloEng helloEng2;

    // constructor injection
    // @Autowired
    public SpringDemoApplication(@Qualifier("helloY")  HelloEng helloEng1,
                                 @Value("${xyz.abc.test}") String str) {
        // Init
        this.helloEng1 = helloEng1;
        this.str = str;
    }

    @PostConstruct
    public void initMe() {
        // init
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(helloEng1.hello("osman") + " " + str);
    }

    @Autowired
    public void methodInject(Environment environment) {
        System.out.println("Server portu : " + environment.getProperty("server.port"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class,
                              args);
    }

}
