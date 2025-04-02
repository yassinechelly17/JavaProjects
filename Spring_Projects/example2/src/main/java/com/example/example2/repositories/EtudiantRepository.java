package com.example.example2.repositories;

import com.example.example2.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByNomEt(String nomEt);
    Etudiant findByCin(long cin);
}