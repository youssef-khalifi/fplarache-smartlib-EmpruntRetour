package com.emprunt_retour_service.entities;

import com.emprunt_retour_service.model.Livre;
import com.emprunt_retour_service.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data@Entity@AllArgsConstructor@NoArgsConstructor@Builder
public class Emprunt {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private EmpruntStatus status;
    private LocalDate dateRetour;
    private Long id_user;
    private Long id_livre;

    @Transient
    private Livre livre;
    @Transient
    private User user;
}
