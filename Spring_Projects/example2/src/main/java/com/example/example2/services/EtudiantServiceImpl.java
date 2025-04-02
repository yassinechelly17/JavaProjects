package com.example.example2.services;

import com.example.example2.entities.Etudiant;
import com.example.example2.entities.Reservation;
import com.example.example2.repositories.EtudiantRepository;
import com.example.example2.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private EtudiantRepository etudiantRepository;
    private ReservationRepository reservationRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant affecterEtudiantAReservation(Long idEtudiant, String idReservation) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
        
        if (etudiant != null && reservation != null) {
            List<Etudiant> etudiants = reservation.getEtudiant();
            etudiants.add(etudiant);
            reservation.setEtudiant(etudiants);
            reservationRepository.save(reservation);
            
            List<Reservation> reservations = etudiant.getReservations();
            reservations.add(reservation);
            etudiant.setReservations(reservations);
            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    // ... existing code ...

@Override
public Etudiant assignEtudiantToReservation(Long idEtudiant, String idReservation) {
    Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
    Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
    
    if (etudiant != null && reservation != null) {
        // Add etudiant to reservation
        List<Etudiant> etudiants = reservation.getEtudiant();
        if (etudiants == null) {
            etudiants = new ArrayList<>();
        }
        if (!etudiants.contains(etudiant)) {
            etudiants.add(etudiant);
            reservation.setEtudiant(etudiants);
            reservationRepository.save(reservation);
        }
    }
    
    return etudiant;
}
}