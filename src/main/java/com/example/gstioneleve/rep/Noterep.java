package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.entites.Note;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Noterep extends JpaRepository<Note, Long> {
    List<Note> findByEleve_IdelAndMatiere_idAndTrimestre(Long idel, Long id_matiere, Trimestre trimestre);
   // List<Note> findByEleve_IdelAndTrimestre (Long eleveIdel , Trimestre trimestre);

}
