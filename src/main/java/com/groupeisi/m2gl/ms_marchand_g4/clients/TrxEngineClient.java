package com.groupeisi.m2gl.ms_marchand_g4.clients;

import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "trx-engine-service",url = "http://localhost:8081")
public interface TrxEngineClient {
    //TODO: compléter le mapping selon l'API de TRX-ENGINE
    @GetMapping("/api/users/byphone/{phone}")
    UserResponse getUserByPhone(String phone);
}
