package com.example.example2.repositories;

import com.example.example2.entities.Chambre;
import com.example.example2.entities.Foyer;
import com.example.example2.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByTypeC(TypeChambre typeC);
    List<Chambre> findByBlocIdBloc(Long idBloc);
    List<Chambre> findAllByTypeC(TypeChambre typeChambre);
    
    // Méthode pour trouver une chambre par son numéro exact
    Chambre findByNumeroChambre(long numeroChambre);
    
    // Méthode pour trouver des chambres par ordre de numéro
    List<Chambre> findAllByOrderByNumeroChambreAsc();
    
    // Méthode pour trouver des chambres dont le numéro est supérieur à une valeur
    List<Chambre> findByNumeroChambreGreaterThan(long numeroChambre);
    
    // Méthode pour trouver des chambres dont le numéro est inférieur à une valeur
    List<Chambre> findByNumeroChambreLessThan(long numeroChambre);
    
    // Méthode pour trouver des chambres dont le numéro est entre deux valeurs
    List<Chambre> findByNumeroChambreBetween(long min, long max);
    
    // Nouvelle méthode pour trouver le foyer associé aux chambres dont les numéros figurent dans une liste
    @Query("SELECT DISTINCT c.bloc.foyer FROM Chambre c WHERE c.numeroChambre IN :numeros")
    List<Foyer> findFoyerByChambreNumerosIn(@Param("numeros") List<Long> numeros);
    
    // Méthode pour compter les chambres ayant une réservation non valide et année universitaire < année courante
    @Query("SELECT COUNT(DISTINCT c) FROM Chambre c JOIN c.reservations r WHERE r.estValide = false AND r.anneeUniversitaire < :currentDate")
    Long countChambresWithInvalidReservationBeforeDate(@Param("currentDate") Date currentDate);
}