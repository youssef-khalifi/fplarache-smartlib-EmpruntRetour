package com.emprunt_retour_service.entities;

import com.emprunt_retour_service.model.Livre;
import com.emprunt_retour_service.model.User;

import java.time.LocalDate;
import java.util.Date;

public class Emprunt {

    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private EmpruntStatus status;
    private LocalDate dateRetour;
    private Long id_user;
    private Long id_livre;

    private Livre livre;
    private User user;
}
