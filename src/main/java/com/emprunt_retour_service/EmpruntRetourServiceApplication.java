package com.emprunt_retour_service;

import com.emprunt_retour_service.entities.Emprunt;
import com.emprunt_retour_service.entities.EmpruntStatus;
import com.emprunt_retour_service.service.EmpruntService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class EmpruntRetourServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpruntRetourServiceApplication.class, args);
    }


}
