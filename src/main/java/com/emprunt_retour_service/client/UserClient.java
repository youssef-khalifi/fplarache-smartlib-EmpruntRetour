package com.emprunt_retour_service.client;

import com.emprunt_retour_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "User", url = "http://localhost:8081/api/users")
public interface UserClient {
        @GetMapping("/{id}")
        User getUserById(@PathVariable Long id);
}
