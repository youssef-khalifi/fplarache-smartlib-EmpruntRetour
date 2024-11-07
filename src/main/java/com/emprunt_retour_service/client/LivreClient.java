package com.emprunt_retour_service.client;

import com.emprunt_retour_service.model.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog_service", url = "")
public interface LivreClient {

    @GetMapping("/v1/Livers/{id}")
    Livre getLivreById(@PathVariable Long id);
}
