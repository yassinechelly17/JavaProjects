package com.example.ftn_entities.contenu;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Language {

    @Id
    @Column(length = 5) // ex: "fr", "ar", "en"
    private String code;

    @Column(nullable = false, length = 50)
    private String nom;

    // Relation inverse (optionnelle)
    // @OneToMany(mappedBy = "language")
    // private Set<NewsItem> newsItems = new HashSet<>();
}

