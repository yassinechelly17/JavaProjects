package com.example.ftn_entities.contenu;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DocumentOfficiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    @Column(nullable = false, length = 200)
    private String titre;

    @Lob
    private String description;

    // Relation vers le fichier physique
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) // Gérer le fichier lié
    @JoinColumn(name = "media_file_id", referencedColumnName = "fileId")
    private MediaFile fichierLie;
}
