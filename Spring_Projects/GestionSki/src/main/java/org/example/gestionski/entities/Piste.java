package org.example.gestionski.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Piste {
    @Id
    private Long numPiste;
    private String nomPiste;
    private Couleur couleur;
    private int longueur;
    private int pente;

    @ManyToMany(mappedBy = "pistes")
    private List<Skieur> skieurs;
}
