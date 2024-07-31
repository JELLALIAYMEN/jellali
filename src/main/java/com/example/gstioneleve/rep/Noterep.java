package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.entites.Note;
import com.example.gstioneleve.entites.Periode;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Noterep extends JpaRepository<Note, Long> {
//    @Query("SELECT n FROM Note n WHERE n.eleve.code = :code AND n.matiere = :matiere AND n.periode = :periode")
//    List<Note> findByCodeAndMatiereAndPeriode(
//            @Param("code") String code,
//            @Param("matiere") Matiere matiere,
//            @Param("periode") Periode periode
//    );
}
