package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Cycle;
import com.example.gstioneleve.entites.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Eleverep extends JpaRepository<Eleve,Long> {


    Eleve findByCode(String code);



    public List<Eleve> findByCycle(Cycle cycle);
}