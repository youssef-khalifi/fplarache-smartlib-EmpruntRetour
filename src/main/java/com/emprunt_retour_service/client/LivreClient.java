package com.emprunt_retour_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "catalog_service", url = "")
public class LivreClient {
}
