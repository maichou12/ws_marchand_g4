package com.groupeisi.m2gl.ms_marchand_g4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsMarchandG4Application {

    public static void main(String[] args) {
        SpringApplication.run(MsMarchandG4Application.class, args);
    }

}
