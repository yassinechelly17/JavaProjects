package com.example.example2.services;

import com.example.example2.entities.Bloc;
import com.example.example2.entities.Chambre;
import com.example.example2.entities.Foyer;
import com.example.example2.repositories.BlocRepository;
import com.example.example2.repositories.ChambreRepository;
import com.example.example2.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {

    private BlocRepository blocRepository;
    private ChambreRepository chambreRepository;
    private FoyerRepository foyerRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (bloc != null) {
            List<Chambre> chambres = new ArrayList<>();
            for (Long numChambre : numChambres) {
                Chambre chambre = chambreRepository.findById(numChambre).orElse(null);
                if (chambre != null) {
                    chambre.setBloc(bloc);
                    chambreRepository.save(chambre);
                    chambres.add(chambre);
                }
            }
            bloc.setChambres(chambres);
            return blocRepository.save(bloc);
        }
        return null;
    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        if (bloc != null && foyer != null) {
            bloc.setFoyer(foyer);
            return blocRepository.save(bloc);
        }
        return null;
    }

    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        if (bloc != null && foyer != null) {
            bloc.setFoyer(foyer);
            return blocRepository.save(bloc);
        }
        return null;
    }
}