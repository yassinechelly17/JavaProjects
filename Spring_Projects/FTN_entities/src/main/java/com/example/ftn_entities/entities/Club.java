package com.example.ftn_entities.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 50)
    private String region;

    @Column(length = 50)
    private String ville;

    @Column(length = 255)
    private String infoContact;

    @Column(length = 255)
    private String siteWeb;

    // Relations inverses
    @OneToMany(mappedBy = "club")
    private Set<Athlete> athletesMembres = new HashSet<>();

    @OneToMany(mappedBy = "clubAffilie")
    private Set<Coach> coachesAffilies = new HashSet<>();
}

