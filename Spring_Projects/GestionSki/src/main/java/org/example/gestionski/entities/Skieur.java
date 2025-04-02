package org.example.gestionski.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Skieur {
    @Id
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @OneToMany(mappedBy = "skieur")
    private List<Inscription> inscriptions;

    @OneToOne(mappedBy = "skieur", cascade = CascadeType.ALL)
    private Abonnement abonnement;

    @ManyToMany
    private List<Piste> pistes;
}
