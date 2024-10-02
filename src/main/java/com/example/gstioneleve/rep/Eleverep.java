package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Classe;
import com.example.gstioneleve.entites.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Eleverep extends JpaRepository<Eleve,Long> {


    Eleve findByCode(String code);




}