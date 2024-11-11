package com.emprunt_retour_service.repositories;

import com.emprunt_retour_service.entities.Emprunt;
import com.emprunt_retour_service.entities.EmpruntStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {


    @Query("select e from Emprunt e where e.id_user = :userId")
    List<Emprunt> findByIdUser(Long userId);

    @Query("select e from Emprunt e where e.status = :status")
    List<Emprunt> findByStatus(EmpruntStatus status);


    @Query("select e from Emprunt e where e.dateDebut between :dateDebut and :dateFin")
    List<Emprunt> findByDateDebutBetween(Date dateDebut, Date dateFin);

}
