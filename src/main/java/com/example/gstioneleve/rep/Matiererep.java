package com.example.gstioneleve.rep;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.entites.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Matiererep extends JpaRepository<Matiere,Long> {
    @Query("SELECT m FROM Matiere m JOIN Note n ON n.matiere.id = m.id WHERE n.eleve.id = :eleveId")
    List<Matiere> findMatieresByEleveId(@Param("eleveId") Long eleveId);

}
