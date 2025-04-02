package com.example.example2.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;

    @OneToOne(mappedBy = "foyer")
    private Universite universite;
}
