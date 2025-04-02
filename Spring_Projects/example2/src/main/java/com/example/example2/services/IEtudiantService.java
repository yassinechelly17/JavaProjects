package com.example.example2.services;

import com.example.example2.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(Long idEtudiant);
    void removeEtudiant(Long idEtudiant);
    Etudiant affecterEtudiantAReservation(Long idEtudiant, String idReservation);
    Etudiant assignEtudiantToReservation(Long idEtudiant, String idReservation);
}