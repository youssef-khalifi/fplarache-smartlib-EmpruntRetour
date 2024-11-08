package com.emprunt_retour_service.client;

import com.emprunt_retour_service.model.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Livre", url = "http://localhost:8082/api/livres")
public interface LivreClient {

    @GetMapping("/{id}")
    Livre getLivreById(@PathVariable Long id);
}
