package com.example.example2.services;

import com.example.example2.entities.Bloc;
import com.example.example2.entities.Foyer;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc b);
    Bloc updateBloc(Bloc b);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);
    Bloc affecterChambresABloc(List<Long> numChambre, Long idBloc);
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer);
    Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer);
}