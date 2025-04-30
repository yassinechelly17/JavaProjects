package com.example.ftn_entities.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class HeroSlide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slideId;

    @Column(nullable = false, length = 100)
    private String titre;

    @Column(length = 255)
    private String texte;

    @Column(nullable = false, length = 255)
    private String imageUrl;

    @Column(length = 255)
    private String lien; // Peut être interne ou externe

    private Integer ordreAffichage;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false) // Qui a géré ce slide
    private Admin gestionnaire;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_item_id") // Lien optionnel vers une news spécifique
    private NewsItem newsItemLie;
}

