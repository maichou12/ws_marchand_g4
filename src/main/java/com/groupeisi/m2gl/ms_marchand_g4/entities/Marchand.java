package com.groupeisi.m2gl.ms_marchand_g4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "Marchands")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Marchand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomBoutique;
    private String logoBoutique;
    private String password;
    private int user_id;
}
