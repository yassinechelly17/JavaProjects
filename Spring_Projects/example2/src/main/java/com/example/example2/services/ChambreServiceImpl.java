package com.example.example2.services;

import com.example.example2.entities.Bloc;
import com.example.example2.entities.Chambre;
import com.example.example2.entities.TypeChambre;
import com.example.example2.repositories.ChambreRepository;
import com.example.example2.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Date;
import com.example.example2.entities.Foyer;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private ChambreRepository chambreRepository;
    private BlocRepository blocRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParTypeEtBloc(TypeChambre type, Long idBloc) {
        List<Chambre> chambres = chambreRepository.findByBlocIdBloc(idBloc);
        return chambres.stream()
                .filter(chambre -> chambre.getTypeC() == type)
                .collect(Collectors.toList());
    }

    @Override
    public List<Chambre> getChambresByTypeC(TypeChambre typeC) {
        // Use the correct repository method
        return chambreRepository.findByTypeC(typeC);
    }

    @Override
    public Chambre getChambreByNumero(long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Override
    public List<Chambre> getAllChambresOrderedByNumero() {
        return chambreRepository.findAllByOrderByNumeroChambreAsc();
    }

    @Override
    public List<Chambre> getChambresWithNumeroGreaterThan(long numero) {
        return chambreRepository.findByNumeroChambreGreaterThan(numero);
    }

    @Override
    public List<Chambre> getChambresWithNumeroLessThan(long numero) {
        return chambreRepository.findByNumeroChambreLessThan(numero);
    }

    @Override
    public List<Chambre> getChambresWithNumeroBetween(long min, long max) {
        return chambreRepository.findByNumeroChambreBetween(min, max);
    }

    @Override
    public List<Foyer> getFoyerByChambreNumeros(List<Long> numeros) {
        return chambreRepository.findFoyerByChambreNumerosIn(numeros);
    }

    @Override
    public Long countChambresWithInvalidReservationBeforeCurrentDate() {
        Date currentDate = new Date();
        return chambreRepository.countChambresWithInvalidReservationBeforeDate(currentDate);
    }

    @Override
    public Chambre affecterChambreABloc(Long num, Integer idBloc) {
        // Find the chamber by its number
        Chambre chambre = chambreRepository.findByNumeroChambre(num);

        // Find the bloc by its ID (need to convert Integer to Long)
        Bloc bloc = blocRepository.findById(idBloc.longValue()).orElse(null);

        if (chambre != null && bloc != null) {
            // Assign the chamber to the bloc
            chambre.setBloc(bloc);

            // Update the bloc's chambers list if needed
            List<Chambre> chambres = bloc.getChambres();
            if (chambres == null) {
                chambres = new ArrayList<>();
            }
            if (!chambres.contains(chambre)) {
                chambres.add(chambre);
                bloc.setChambres(chambres);
                blocRepository.save(bloc);
            }

            // Save and return the updated chamber
            return chambreRepository.save(chambre);
        }
        return null;
    }

    @Override
    public void desaffecterChambreDeBloc(Long num, Integer idBloc) {
        // Find the chamber by its number
        Chambre chambre = chambreRepository.findByNumeroChambre(num);

        // Find the bloc by its ID (need to convert Integer to Long)
        Bloc bloc = blocRepository.findById(idBloc.longValue()).orElse(null);

        if (chambre != null && bloc != null && chambre.getBloc() != null
                && chambre.getBloc().getIdBloc().equals(bloc.getIdBloc())) {
            // Remove the chamber from the bloc
            chambre.setBloc(null);
            chambreRepository.save(chambre);

            // Update the bloc's chambers list
            List<Chambre> chambres = bloc.getChambres();
            if (chambres != null) {
                chambres.removeIf(c -> c.getNumeroChambre() == num);
                bloc.setChambres(chambres);
                blocRepository.save(bloc);
            }
        }
    }
}