package com.emprunt_retour_service.service;

import com.emprunt_retour_service.client.LivreClient;
import com.emprunt_retour_service.client.UserClient;
import com.emprunt_retour_service.entities.Emprunt;
import com.emprunt_retour_service.entities.EmpruntStatus;
import com.emprunt_retour_service.repositories.EmpruntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final UserClient userClient;
    private final LivreClient livreClient;



    public Emprunt create(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public List<Emprunt> findAll() {
        List<Emprunt> emprunts = empruntRepository.findAll();
       /* emprunts.forEach(emprunt -> {
            emprunt.setLivre(livreClient.getLivreById(emprunt.getId_livre()));
            emprunt.setUser(userClient.getUserById(emprunt.getId_user()));
        });*/
        return emprunts;
    }

    public Emprunt findById(Long id) {
        Emprunt emprunt = empruntRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt not found"));
       /* emprunt.setLivre(livreClient.getLivreById(emprunt.getId_livre()));
        emprunt.setUser(userClient.getUserById(emprunt.getId_user()));*/
        return emprunt;
    }

    public Emprunt update(Long id, Emprunt emprunt) {
        return empruntRepository.findById(id).map(existingEmprunt -> {
            existingEmprunt.setStatus(emprunt.getStatus());
            existingEmprunt.setDateFin(emprunt.getDateFin());
            existingEmprunt.setDateRetour(emprunt.getDateRetour());
            existingEmprunt.setId_livre(emprunt.getId_livre());
            existingEmprunt.setId_user(emprunt.getId_user());
            return empruntRepository.save(existingEmprunt);
        }).orElseThrow(() -> new RuntimeException("Emprunt not found"));
    }

    public void delete(Long id) {
        empruntRepository.deleteById(id);
    }


    public List<Emprunt> findByUserId(Long id){

        return empruntRepository.findByIdUser(id);
    }

    public List<Emprunt> findByStatus(String status){
        String st = status.toUpperCase();
        EmpruntStatus status1 = EmpruntStatus.valueOf(st);


        return empruntRepository.findByStatus(status1);
    }

    public List<Emprunt> findByDateDebutBetween(Date startDate, Date endDate) {
        return empruntRepository.findByDateDebutBetween(startDate, endDate);
    }
}
