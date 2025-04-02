package com.example.example2.controllers;

import com.example.example2.entities.Reservation;
import com.example.example2.repositories.ReservationRepository;
import com.example.example2.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationRepository reservationRepository;

    private IReservationService reservationService;

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable("id") String id) {
        return reservationService.retrieveReservation(id);
    }

    @PostMapping
    public Reservation add(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        reservationService.removeReservation(id);
    }

    @PostMapping("/ajouter-et-assigner")
    public Reservation ajouterEtAssigner(
            @RequestBody Reservation reservation,
            @RequestParam Long numChambre,
            @RequestParam Long cin) {
        return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(reservation, numChambre, cin);
    }

    @GetMapping("/etudiants-with-valid-reservation")
    public List<String> getEtudiantsWithValidReservation() {
        return reservationService.getNomEtudiantsWithValidReservationForCurrentYear();
    }

    @GetMapping("/test-valid-reservations")
    public List<String> testValidReservations(@RequestParam("date") String dateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date testDate = format.parse(dateStr);

            List<Object[]> results = reservationRepository.findDistinctEtudiantNamesWithValidReservationForYear(testDate);
            return results.stream()
                    .map(result -> result[0] + " " + result[1])
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Use yyyy-MM-dd", e);
        }
    }

    @GetMapping("/create-test-reservations")
    public List<Reservation> createTestReservations() {
        // Create a valid reservation for current year
        Reservation validReservation = new Reservation();
        validReservation.setIdReservation("RES-VALID-" + System.currentTimeMillis());
        validReservation.setAnneeUniversitaire(new Date()); // Current date
        validReservation.setEstValide(true);

        // Create an invalid reservation for previous year
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1); // Previous year

        Reservation invalidReservation = new Reservation();
        invalidReservation.setIdReservation("RES-INVALID-" + System.currentTimeMillis());
        invalidReservation.setAnneeUniversitaire(cal.getTime());
        invalidReservation.setEstValide(false);

        // Save both reservations
        reservationService.addReservation(validReservation);
        reservationService.addReservation(invalidReservation);

        // Return all reservations to show the result
        return reservationService.retrieveAllReservations();
    }

    @PostMapping("/ajouter-avec-etudiants")
    public Reservation ajouterAvecEtudiants(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservationAvecEtudiants(reservation);
    }
}