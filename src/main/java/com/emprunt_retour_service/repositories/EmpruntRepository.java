package com.emprunt_retour_service.repositories;

import com.emprunt_retour_service.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}
