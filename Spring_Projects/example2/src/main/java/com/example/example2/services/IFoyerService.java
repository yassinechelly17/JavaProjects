package com.example.example2.services;

import com.example.example2.entities.Foyer;
import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    Foyer retrieveFoyer(Long idFoyer);
    void removeFoyer(Long idFoyer);
    Foyer affecterFoyerAUniversite(Long idFoyer, Long idUniversite);
    Foyer ajouterFoyerAvecBlocsAssociés(Foyer foyer);
}