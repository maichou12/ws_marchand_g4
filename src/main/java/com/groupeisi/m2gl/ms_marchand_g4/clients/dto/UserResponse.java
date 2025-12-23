package com.groupeisi.m2gl.ms_marchand_g4.clients.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Integer id;
    private String message;
    private boolean success;
    private int statusCode;
    private UserData data;
    private String telephone;
    private Integer compteId;
    private String nomUtilisateur;
}
