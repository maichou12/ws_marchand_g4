package com.groupeisi.m2gl.ms_marchand_g4.clients.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class UserData {
    private Integer id;
    private String keycloakId;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String telephone;
    private String nin;
    private String roleName;
    private Integer compteId;
}
