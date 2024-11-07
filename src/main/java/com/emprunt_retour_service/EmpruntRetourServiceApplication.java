package com.emprunt_retour_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmpruntRetourServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpruntRetourServiceApplication.class, args);
    }

}
