package com.silentao.parsley.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ParsleyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParsleyServerApplication.class, args);
    }
}
