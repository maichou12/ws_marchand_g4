package com.groupeisi.m2gl.ms_marchand_g4.clients;

import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.CompteResponse;
import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserByPhoneResponse;
import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "trx-engine-service",url = "http://localhost:8080")
public interface TrxEngineClient {
    //TODO: compléter le mapping selon l'API de TRX-ENGINE
    @GetMapping("/api/users/getUserByPhone/{phone}")
    UserByPhoneResponse getUserByPhone(@PathVariable("phone") String phone);

    /*@PostMapping("/api/comptes/create-marchand/{userId}")
    CompteResponse createCompteMarchand(@PathVariable("userId") Integer userId);*/
    @PostMapping("/api/compte/create-marchand/{telephone}")
    CompteResponse createCompteMarchand(@PathVariable String telephone);

}
