package com.mirac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdminRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminRegistryApplication.class);
    }
}
