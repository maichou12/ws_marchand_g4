package com.groupeisi.m2gl.ms_marchand_g4.clients;

import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TrxEngineClient {
    @Value("${trxengine.baseurl}")
    private String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public UserResponse getUserByPhone(String phone) {
        return restTemplate.getForObject(
                baseUrl+"/api/users/getUserByPhone/{phone}",
                UserResponse.class,
                phone
        );
    }
}


