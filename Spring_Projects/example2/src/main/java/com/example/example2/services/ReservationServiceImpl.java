package com.example.example2.services;

import com.example.example2.entities.Chambre;
import com.example.example2.entities.Etudiant;
import com.example.example2.entities.Reservation;
import com.example.example2.repositories.ChambreRepository;
import com.example.example2.repositories.EtudiantRepository;
import com.example.example2.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private ReservationRepository reservationRepository;
    private ChambreRepository chambreRepository;
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation reservation, Long numChambre, Long cin) {
        Chambre chambre = chambreRepository.findById(numChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findByCin(cin);
        
        if (chambre != null && etudiant != null) {
            // Save the reservation
            Reservation savedReservation = reservationRepository.save(reservation);
            
            // Assign to chambre
            List<Reservation> reservations = chambre.getReservations();
            if (reservations == null) {
                reservations = new ArrayList<>();
            }
            reservations.add(savedReservation);
            chambre.setReservations(reservations);
            chambreRepository.save(chambre);
            
            // Assign to etudiant
            List<Etudiant> etudiants = savedReservation.getEtudiant();
            if (etudiants == null) {
                etudiants = new ArrayList<>();
            }
            etudiants.add(etudiant);
            savedReservation.setEtudiant(etudiants);
            
            // Update etudiant's reservations
            List<Reservation> etudiantReservations = etudiant.getReservations();
            if (etudiantReservations == null) {
                etudiantReservations = new ArrayList<>();
            }
            etudiantReservations.add(savedReservation);
            etudiant.setReservations(etudiantReservations);
            etudiantRepository.save(etudiant);
            
            return reservationRepository.save(savedReservation);
        }
        return null;
    }

    @Override
    public List<String> getNomEtudiantsWithValidReservationForCurrentYear() {
        // Obtenir l'année universitaire courante
        Date currentDate = new Date();
        
        // Utiliser la nouvelle méthode du repository avec keywords JPA
        List<Object[]> results = reservationRepository.findDistinctEtudiantNamesWithValidReservationForYear(currentDate);
        
        // Transformer les résultats en liste de noms complets
        return results.stream()
                .map(result -> result[0] + " " + result[1])
                .collect(Collectors.toList());
    }

    public Reservation ajouterReservationAvecEtudiants(Reservation reservation) {
        if (reservation != null) {
            // Save the reservation first
            Reservation savedReservation = reservationRepository.save(reservation);
            
            // If there are students in the reservation
            if (savedReservation.getEtudiant() != null && !savedReservation.getEtudiant().isEmpty()) {
                List<Etudiant> etudiants = savedReservation.getEtudiant();
                
                // For each student, update their reservations list
                for (Etudiant etudiant : etudiants) {
                    // Make sure the student exists in the database
                    Etudiant existingEtudiant = etudiantRepository.findById(etudiant.getIdEtudiant()).orElse(null);
                    
                    if (existingEtudiant != null) {
                        // Update student's reservations list
                        List<Reservation> etudiantReservations = existingEtudiant.getReservations();
                        if (etudiantReservations == null) {
                            etudiantReservations = new ArrayList<>();
                        }
                        
                        // Add the new reservation if not already present
                        if (!etudiantReservations.contains(savedReservation)) {
                            etudiantReservations.add(savedReservation);
                            existingEtudiant.setReservations(etudiantReservations);
                            etudiantRepository.save(existingEtudiant);
                        }
                    }
                }
            }
            
            return savedReservation;
        }
        return null;
    }
}