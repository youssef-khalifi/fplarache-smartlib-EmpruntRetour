package com.emprunt_retour_service.client;

import com.emprunt_retour_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user_service", url = "")
public interface UserClient {
        @GetMapping("/v1/Users/{id}")
        User getUserById(@PathVariable Long id);
}
