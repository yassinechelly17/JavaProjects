package com.example.ftn_entities.contenu;

import com.example.ftn_entities.contenu.Language;
import com.example.ftn_entities.contenu.MediaFile;
import com.example.ftn_entities.securite.Admin;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime; // Utilisation de LocalDateTime
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class NewsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsItemId;

    @Column(nullable = false, length = 200)
    private String titre;

    @Lob // Pour contenu potentiellement long
    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false)
    private LocalDateTime datePublication;

    @Column(length = 50)
    private String categorie;

    @Column(length = 255) // URL de l'image principale
    private String imageUrl;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auteur_id", nullable = false) // auteur_id est la clé étrangère
    private Admin auteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code") // language_code est la clé étrangère
    private Language language;

    @ManyToMany // Relation possible avec MediaFile pour les images/vidéos intégrées
    @JoinTable(
            name = "newsitem_media",
            joinColumns = @JoinColumn(name = "news_item_id"),
            inverseJoinColumns = @JoinColumn(name = "media_file_id")
    )
    private Set<MediaFile> mediaContenu = new HashSet<>();

    // Relation optionnelle vers HeroSlide (si un slide pointe vers cette news)
    @OneToOne(mappedBy = "newsItemLie")
    private HeroSlide heroSlideAssocie;
}
