package com.silentao.parsley.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ParsleyBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParsleyBaseApplication.class, args);
    }

}
