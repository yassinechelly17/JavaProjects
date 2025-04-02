package com.example.example2.controllers;

import com.example.example2.entities.Universite;
import com.example.example2.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    private IUniversiteService universiteService;

    @GetMapping
    public List<Universite> getAll() {
        return universiteService.retrieveAllUniversites();
    }

    @GetMapping("/{id}")
    public Universite getById(@PathVariable("id") Long id) {
        return universiteService.retrieveUniversite(id);
    }

    @PostMapping
    public Universite add(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping
    public Universite update(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        universiteService.removeUniversite(id);
    }

    @PutMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyer(@PathVariable Long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecter-foyer/{idUniversite}")
    public Universite desaffecterFoyer(@PathVariable Long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}