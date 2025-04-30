package com.example.ftn_entities.membres;

import com.example.ftn_entities.infrastructure.Piste;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Piscine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long piscineId;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 255)
    private String adresse;

    private Integer nombrePistes;

    // Relation
    @OneToMany(mappedBy = "piscine", cascade = CascadeType.ALL, orphanRemoval = true) // Si une piscine est supprimée, ses pistes aussi
    private Set<Piste> pistes = new HashSet<>();
}
