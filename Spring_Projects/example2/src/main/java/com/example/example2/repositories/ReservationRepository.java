package com.example.example2.repositories;

import com.example.example2.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByEstValide(boolean estValide);
    List<Reservation> findByAnneeUniversitaire(Date anneeUniversitaire);
    
    List<Reservation> findByEstValideAndAnneeUniversitaire(boolean estValide, Date anneeUniversitaire);
    
    @Query("SELECT DISTINCT e.nomEt, e.prenomEt FROM Reservation r JOIN r.etudiant e WHERE r.estValide = true AND r.anneeUniversitaire = :anneeUniversitaire")
    List<Object[]> findDistinctEtudiantNamesWithValidReservationForYear(@Param("anneeUniversitaire") Date anneeUniversitaire);
}