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

    @Bean
    CommandLineRunner start(EmpruntService empruntService) {
        return args -> {
            Emprunt emprunt1 = Emprunt.builder()
                    .status(EmpruntStatus.EN_COURS)
                    .dateDebut(new Date())
                    .dateFin(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000L))  // 1 week later
                    .dateRetour(null)
                    .id_livre(1L)
                    .id_user(1L)
                    .build();

            Emprunt emprunt2 = Emprunt.builder()
                    .status(EmpruntStatus.RETOURNE)
                    .dateDebut(new Date(System.currentTimeMillis() - 14 * 24 * 60 * 60 * 1000L)) // 2 weeks ago
                    .dateFin(new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000L))    // 1 week ago
                    .dateRetour(new Date(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000L)) // 2 days ago
                    .id_livre(2L)
                    .id_user(2L)
                    .build();

            Emprunt emprunt3 = Emprunt.builder()
                    .status(EmpruntStatus.EN_COURS)
                    .dateDebut(new Date())
                    .dateFin(new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000L))  // 2 weeks later
                    .dateRetour(null)
                    .id_livre(2L)
                    .id_user(2L)
                    .build();

            Emprunt emprunt4 = Emprunt.builder()
                    .status(EmpruntStatus.EN_RETARD)
                    .dateDebut(new Date(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000L)) // 10 days ago
                    .dateFin(new Date(System.currentTimeMillis() - 5 * 24 * 60 * 60 * 1000L))    // 5 days ago
                    .dateRetour(new Date(System.currentTimeMillis() - 3 * 24 * 60 * 60 * 1000L)) // 3 days ago
                    .id_livre(2L)
                    .id_user(2L)
                    .build();

            Emprunt emprunt5 = Emprunt.builder()
                    .status(EmpruntStatus.EN_COURS)
                    .dateDebut(new Date())
                    .dateFin(new Date(System.currentTimeMillis() + 21 * 24 * 60 * 60 * 1000L))  // 3 weeks later
                    .dateRetour(null)
                    .id_livre(2L)
                    .id_user(2L)
                    .build();


            empruntService.create(emprunt1);
            empruntService.create(emprunt2);
            empruntService.create(emprunt3);
            empruntService.create(emprunt4);
            empruntService.create(emprunt5);
        };
    }
}
