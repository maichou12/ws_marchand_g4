package com.groupeisi.m2gl.ms_marchand_g4.clients;

import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.CompteResponse;
import com.groupeisi.m2gl.ms_marchand_g4.clients.dto.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class TrxClientImpl implements TrxEngineClient {
    @Value("${trxengine.baseurl}")
    private String baseUrl;
    private final org.springframework.web.client.RestTemplate restTemplate;

    public TrxClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserResponse getUserByPhone(String phone) {
        return restTemplate.getForObject(
                baseUrl+"/api/users/getUserByPhone/{phone}",
                UserResponse.class,
                phone
        );
    }

    @Override
    public CompteResponse createCompteMarchand(String telephone) {
        return null;
    }
}
