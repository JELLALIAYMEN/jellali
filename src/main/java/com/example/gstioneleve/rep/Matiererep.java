package com.example.gstioneleve.rep;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.entites.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Matiererep extends JpaRepository<Matiere,Long> {

}
