package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Eleverep extends JpaRepository<Eleve,Long> {





  Optional<Eleve> findByCode(String code);


  //public   Eleve findByCode(String code);
}