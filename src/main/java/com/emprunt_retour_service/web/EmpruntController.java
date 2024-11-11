package com.emprunt_retour_service.web;

import com.emprunt_retour_service.entities.Emprunt;
import com.emprunt_retour_service.service.EmpruntService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
@RequiredArgsConstructor
public class EmpruntController {

    private final EmpruntService empruntService;

    @PostMapping
    public ResponseEntity<Emprunt> create(@RequestBody Emprunt emprunt) {
        Emprunt createdEmprunt = empruntService.create(emprunt);
        return new ResponseEntity<>(createdEmprunt, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Emprunt>> findAll() {
        List<Emprunt> emprunts = empruntService.findAll();
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> findById(@PathVariable Long id) {
        try {
            Emprunt emprunt = empruntService.findById(id);
            return new ResponseEntity<>(emprunt, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> update(@PathVariable Long id, @RequestBody Emprunt emprunt) {
        try {
            Emprunt updatedEmprunt = empruntService.update(id, emprunt);
            return new ResponseEntity<>(updatedEmprunt, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            empruntService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<Emprunt>> findByUserId(@PathVariable Long id) {
        List<Emprunt> emprunts = empruntService.findByUserId(id);
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Emprunt>> findByStatus(@PathVariable String status) {
        List<Emprunt> emprunts = empruntService.findByStatus(status);
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    @GetMapping("/dateDebut")
    public List<Emprunt> getEmpruntsByDateDebutBetween(
            @RequestParam("dateDebut") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateFin) {
        return empruntService.findByDateDebutBetween(dateDebut, dateFin);
    }
}
