package com.groupeisi.m2gl.ms_marchand_g4.clients;

import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.CompteResponse;
import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserByPhoneResponse;
import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@FeignClient(name = "trx-engine-service",url = "${trx-engine.base-url:http://localhost:8081}")
public interface TrxEngineClient {
    @GetMapping("/api/users/getUserByPhone/{phone}")
    UserResponse getUserByPhone(@PathVariable("phone") String phone);

    /*@PostMapping("/api/comptes/create-marchand/{userId}")
    CompteResponse createCompteMarchand(@PathVariable("userId") Integer userId);*/
    @PostMapping("/api/compte/create-marchand/{telephone}")
    CompteResponse createCompteMarchand(@PathVariable String telephone);

}


