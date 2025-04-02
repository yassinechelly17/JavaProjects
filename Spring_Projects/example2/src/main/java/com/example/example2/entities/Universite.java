package com.example.example2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresse;
    
    @OneToOne
    private Foyer foyer;
} 