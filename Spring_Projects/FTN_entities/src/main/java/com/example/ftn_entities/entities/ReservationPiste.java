package com.example.ftn_entities.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ReservationPiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(nullable = false)
    private LocalDateTime dateHeureDebut;

    @Column(nullable = false)
    private LocalDateTime dateHeureFin;

    @Column(length = 20) // Ex: CONFIRMEE, EN_ATTENTE, ANNULEE
    private String statut;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", nullable = false) // Qui a fait la réservation
    private Coach coach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piste_id", nullable = false) // Quelle piste est réservée
    private Piste piste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id") // Qui a géré/approuvé (optionnel)
    private Admin gestionnaireReservation;
}

