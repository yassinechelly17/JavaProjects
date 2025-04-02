package com.example.example2.services;

import com.example.example2.entities.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    Reservation retrieveReservation(String idReservation);
    void removeReservation(String idReservation);
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation reservation, Long numChambre, Long cin);
    Reservation ajouterReservationAvecEtudiants(Reservation reservation);
    
    List<String> getNomEtudiantsWithValidReservationForCurrentYear();
}