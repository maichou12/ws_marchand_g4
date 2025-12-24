package com.groupeisi.m2gl.ms_marchand_g4.clients.dto;

import lombok.Data;

@Data
public class CompteResponse<T> {
    private String message;
    private boolean success;
    private int statusCode;
    private T data;
}
