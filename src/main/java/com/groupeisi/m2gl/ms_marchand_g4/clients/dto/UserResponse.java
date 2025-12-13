package com.groupeisi.m2gl.ms_marchand_g4.clients.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserResponse {

    private String message;
    private boolean success;
    private int statusCode;
    private UserData data;
}

