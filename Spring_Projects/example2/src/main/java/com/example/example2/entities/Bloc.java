package com.example.example2.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;

    @ManyToOne
    private Foyer foyer;
}
