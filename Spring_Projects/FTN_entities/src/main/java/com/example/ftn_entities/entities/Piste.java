package com.example.ftn_entities.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pisteId;

    @Column(nullable = false)
    private Integer numeroPiste;

    private Integer longueur; // Ex: 25, 50

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piscine_id", nullable = false)
    private Piscine piscine;

    @OneToMany(mappedBy = "piste")
    private Set<ReservationPiste> reservations = new HashSet<>();
}

