package com.example.example2.repositories;

import com.example.example2.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    Bloc findByNomBloc(String nomBloc);
}