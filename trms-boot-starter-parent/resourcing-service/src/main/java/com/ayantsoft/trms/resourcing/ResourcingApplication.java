package com.ayantsoft.trms.resourcing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
@ComponentScan("com.ayantsoft.trms")
public class ResourcingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourcingApplication.class, args);
    }
}
