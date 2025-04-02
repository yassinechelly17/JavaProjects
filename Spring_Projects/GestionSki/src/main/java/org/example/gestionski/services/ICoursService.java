package org.example.gestionski.services;

import org.example.gestionski.entities.Cours;
import java.util.List;

public interface ICoursService {
    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    void deleteCours(Long numCours);
    Cours getCours(Long numCours);
    List<Cours> getAllCours();
}