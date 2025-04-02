package com.example.example2.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    
    @ManyToOne
    private Bloc bloc;
    
    @OneToMany
    private List<Reservation> reservations;
}
