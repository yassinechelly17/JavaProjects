package com.example.example2.controllers;

import com.example.example2.entities.Foyer;
import com.example.example2.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {

    private IFoyerService foyerService;

    @GetMapping
    public List<Foyer> getAll() {
        return foyerService.retrieveAllFoyers();
    }

    @GetMapping("/{id}")
    public Foyer getById(@PathVariable("id") Long id) {
        return foyerService.retrieveFoyer(id);
    }

    @PostMapping
    public Foyer add(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping
    public Foyer update(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        foyerService.removeFoyer(id);
    }

    @PutMapping("/affecter-universite/{idFoyer}/{idUniversite}")
    public Foyer affecterUniversite(@PathVariable Long idFoyer, @PathVariable Long idUniversite) {
        return foyerService.affecterFoyerAUniversite(idFoyer, idUniversite);
    }

    @PostMapping("/ajouter-avec-blocs")
    public Foyer ajouterAvecBlocs(@RequestBody Foyer foyer) {
        return foyerService.ajouterFoyerAvecBlocsAssociés(foyer);
    }
}