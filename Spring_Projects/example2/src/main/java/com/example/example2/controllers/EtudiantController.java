package com.example.example2.controllers;

import com.example.example2.entities.Etudiant;
import com.example.example2.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {

    private IEtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAll() {
        return etudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getById(@PathVariable("id") Long id) {
        return etudiantService.retrieveEtudiant(id);
    }

    @PostMapping
    public Etudiant add(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping
    public Etudiant update(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        etudiantService.removeEtudiant(id);
    }

    @PutMapping("/assign-to-reservation")
    public Etudiant assignToReservation(
        @RequestParam Long idEtudiant,
        @RequestParam String idReservation) {
        return etudiantService.assignEtudiantToReservation(idEtudiant, idReservation);
    }

    @PutMapping("/affecter-reservation/{idEtudiant}/{idReservation}")
    public Etudiant affecterReservation(@PathVariable Long idEtudiant, @PathVariable String idReservation) {
        return etudiantService.affecterEtudiantAReservation(idEtudiant, idReservation);
    }
}