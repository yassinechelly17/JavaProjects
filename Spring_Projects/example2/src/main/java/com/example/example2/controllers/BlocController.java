package com.example.example2.controllers;

import com.example.example2.entities.Bloc;
import com.example.example2.entities.Chambre;
import com.example.example2.entities.Foyer;
import com.example.example2.entities.TypeChambre;
import com.example.example2.repositories.BlocRepository;
import com.example.example2.repositories.ChambreRepository;
import com.example.example2.repositories.FoyerRepository;
import com.example.example2.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {

    private IBlocService blocService;
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @GetMapping
    public List<Bloc> getAll() {
        return blocService.retrieveAllBlocs();
    }

    @GetMapping("/{id}")
    public Bloc getById(@PathVariable("id") Long id) {
        return blocService.retrieveBloc(id);
    }

    @PostMapping
    public Bloc add(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping
    public Bloc update(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        blocService.removeBloc(id);
    }

    @PutMapping("/affecter-chambres/{idBloc}")
    public Bloc affecterChambres(@RequestBody List<Long> numChambres, @PathVariable Long idBloc) {
        return blocService.affecterChambresABloc(numChambres, idBloc);
    }

    @PutMapping("/affecter-foyer/{idBloc}/{idFoyer}")
    public Bloc affecterFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        // This method should call the version that takes two Long parameters
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        if (bloc != null && foyer != null) {
            return blocService.affecterBlocAFoyer(bloc.getNomBloc(), foyer);
        }
        return null;
    }

    @PutMapping("/affecter-foyer-by-name")
    public Bloc affecterFoyerByName(@RequestParam String nomBloc, @RequestBody Foyer foyer) {
        return blocService.affecterBlocAFoyer(nomBloc, foyer);
    }

    @GetMapping("/create-sample-blocs-with-chambers")
    public List<Bloc> createSampleBlocsWithChambers() {
        // Create a foyer first
        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Sample Foyer");
        foyer.setCapaciteFoyer(100L);
        foyer = foyerRepository.save(foyer);

        // Create first bloc
        Bloc bloc1 = new Bloc();
        bloc1.setNomBloc("Bloc A");
        bloc1.setCapaciteBloc(50);
        bloc1.setFoyer(foyer);

        bloc1 = blocRepository.save(bloc1);

        // Create second bloc
        Bloc bloc2 = new Bloc();
        bloc2.setNomBloc("Bloc B");
        bloc2.setCapaciteBloc(50);
        bloc2.setFoyer(foyer);
        bloc2 = blocRepository.save(bloc2);

        // Create chambers for bloc1
        List<Chambre> chambresBloc1 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Chambre chambre = new Chambre();
            chambre.setNumeroChambre(100 + i);
            chambre.setTypeC(i % 3 == 0 ? TypeChambre.TRIPLE :
                             i % 2 == 0 ? TypeChambre.DOUBLE : TypeChambre.SIMPLE);
            chambre.setBloc(bloc1);
            chambresBloc1.add(chambreRepository.save(chambre));
        }

        // Create chambers for bloc2
        List<Chambre> chambresBloc2 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Chambre chambre = new Chambre();
            chambre.setNumeroChambre(200 + i);
            chambre.setTypeC(i % 3 == 0 ? TypeChambre.TRIPLE : 
                             i % 2 == 0 ? TypeChambre.DOUBLE : TypeChambre.SIMPLE);
            chambre.setBloc(bloc2);
            chambresBloc2.add(chambreRepository.save(chambre));
        }

        // Return all blocs to show the result
        return blocRepository.findAll();
    }
}