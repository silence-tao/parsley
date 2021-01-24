package com.silentao.parsley.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ParsleyLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParsleyLoginApplication.class, args);
    }

}
