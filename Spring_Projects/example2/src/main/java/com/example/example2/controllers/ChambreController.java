package com.example.example2.controllers;

import com.example.example2.entities.Chambre;
import com.example.example2.entities.Foyer;
import com.example.example2.entities.TypeChambre;
import com.example.example2.services.IChambreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Chambre API", description = "Chambre API")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {

    private IChambreService chambreService;

    @GetMapping
    public List<Chambre> getAll() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/{id}")
    public Chambre getById(@PathVariable("id") Long id) {
        return chambreService.retrieveChambre(id);
    }

    @PostMapping
    public Chambre add(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping
    public Chambre update(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        chambreService.removeChambre(id);
    }

    @GetMapping("/by-type-and-bloc")
    public List<Chambre> getByTypeAndBloc(@RequestParam TypeChambre type, @RequestParam Long idBloc) {
        return chambreService.getChambresParTypeEtBloc(type, idBloc);
    }

    @GetMapping("/by-type/{type}")
    public List<Chambre> getByTypePathVariable(@PathVariable TypeChambre type) {
        return chambreService.getChambresByTypeC(type);
    }

    @GetMapping("/create-sample-chambers")
    public List<Chambre> createSampleChambers() {
        // Create a SIMPLE chamber
        Chambre simpleChambre = new Chambre();
        simpleChambre.setNumeroChambre(101);
        simpleChambre.setTypeC(TypeChambre.SIMPLE);

        // Create a DOUBLE chamber
        Chambre doubleChambre = new Chambre();
        doubleChambre.setNumeroChambre(102);
        doubleChambre.setTypeC(TypeChambre.DOUBLE);

        // Save both chambers
        chambreService.addChambre(simpleChambre);
        chambreService.addChambre(doubleChambre);

        // Return all chambers to show the result
        return chambreService.retrieveAllChambres();
    }

    // Keep the JPA keyword-based endpoints
    @GetMapping("/by-numero/{numero}")
    public Chambre getByNumero(@PathVariable long numero) {
        return chambreService.getChambreByNumero(numero);
    }

    @GetMapping("/ordered-by-numero")
    public List<Chambre> getAllOrderedByNumero() {
        return chambreService.getAllChambresOrderedByNumero();
    }

    @GetMapping("/with-numero-greater-than/{numero}")
    public List<Chambre> getWithNumeroGreaterThan(@PathVariable long numero) {
        return chambreService.getChambresWithNumeroGreaterThan(numero);
    }

    @GetMapping("/with-numero-less-than/{numero}")
    public List<Chambre> getWithNumeroLessThan(@PathVariable long numero) {
        return chambreService.getChambresWithNumeroLessThan(numero);
    }

    @GetMapping("/with-numero-between")
    public List<Chambre> getWithNumeroBetween(
            @RequestParam long min,
            @RequestParam long max) {
        return chambreService.getChambresWithNumeroBetween(min, max);
    }

    @GetMapping("/foyer-by-chambre-numeros")
    public List<Foyer> getFoyerByChambreNumeros(@RequestParam List<Long> numeros) {
        return chambreService.getFoyerByChambreNumeros(numeros);
    }

    @GetMapping("/count-invalid-reservations")
    public Long countChambresWithInvalidReservationBeforeCurrentDate() {
        return chambreService.countChambresWithInvalidReservationBeforeCurrentDate();
    }

    @PutMapping("/affecter-bloc")
    public Chambre affecterBloc(@RequestParam Long numeroChambre, @RequestParam Integer idBloc) {
        return chambreService.affecterChambreABloc(numeroChambre, idBloc);
    }

    @PutMapping("/desaffecter-bloc")
    public void desaffecterBloc(@RequestParam Long numeroChambre, @RequestParam Integer idBloc) {
        chambreService.desaffecterChambreDeBloc(numeroChambre, idBloc);
    }
}