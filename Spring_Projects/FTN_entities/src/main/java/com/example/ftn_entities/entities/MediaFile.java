package com.example.ftn_entities.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(nullable = false, length = 255)
    private String nomFichier;

    @Column(nullable = false, length = 500) // Chemin ou URL
    private String cheminFichier;

    @Column(length = 50) // Mime type ou extension
    private String typeFichier;

    private LocalDateTime dateUpload = LocalDateTime.now();

    // Note: Les relations inverses (@ManyToMany avec NewsItem, @OneToOne avec DocOfficiel, etc.)
    // ne sont généralement pas nécessaires ici si la navigation se fait depuis l'entité principale.
}
