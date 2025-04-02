package com.example.example2.services;

import com.example.example2.entities.Chambre;
import com.example.example2.entities.Foyer;
import com.example.example2.entities.TypeChambre;
import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre(Chambre c);
    Chambre retrieveChambre(Long idChambre);
    void removeChambre(Long idChambre);
    List<Chambre> getChambresParTypeEtBloc(TypeChambre type, Long idBloc);
    List<Chambre> getChambresByTypeC(TypeChambre typeC);
    
    // JPA keyword methods
    Chambre getChambreByNumero(long numeroChambre);
    List<Chambre> getAllChambresOrderedByNumero();
    List<Chambre> getChambresWithNumeroGreaterThan(long numero);
    List<Chambre> getChambresWithNumeroLessThan(long numero);
    List<Chambre> getChambresWithNumeroBetween(long min, long max);
    
    // Nouvelles méthodes
    List<Foyer> getFoyerByChambreNumeros(List<Long> numeros);
    Long countChambresWithInvalidReservationBeforeCurrentDate();

    // Add these methods to the interface
    Chambre affecterChambreABloc(Long num, Integer idBloc);
    void desaffecterChambreDeBloc(Long num, Integer idBloc);
}