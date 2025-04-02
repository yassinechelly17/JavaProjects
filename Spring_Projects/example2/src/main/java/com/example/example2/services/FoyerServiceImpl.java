package com.example.example2.services;

import com.example.example2.entities.Bloc;
import com.example.example2.entities.Foyer;
import com.example.example2.entities.Universite;
import com.example.example2.repositories.BlocRepository;
import com.example.example2.repositories.FoyerRepository;
import com.example.example2.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    private FoyerRepository foyerRepository;
    private UniversiteRepository universiteRepository;
    private BlocRepository blocRepository; // Add this repository
    
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer affecterFoyerAUniversite(Long idFoyer, Long idUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        
        if (foyer != null && universite != null) {
            universite.setFoyer(foyer);
            universiteRepository.save(universite);
            return foyer;
        }
        return null;
    }

    @Override
    public Foyer ajouterFoyerAvecBlocsAssociés(Foyer foyer) {
        // First save the foyer to get an ID
        Foyer savedFoyer = foyerRepository.save(foyer);
        
        // If the foyer has associated blocs
        if (savedFoyer.getBlocs() != null && !savedFoyer.getBlocs().isEmpty()) {
            List<Bloc> blocs = savedFoyer.getBlocs();
            
            // For each bloc, set the foyer and save it
            for (Bloc bloc : blocs) {
                bloc.setFoyer(savedFoyer);
                blocRepository.save(bloc);
            }
        }
        
        return savedFoyer;
    }
}