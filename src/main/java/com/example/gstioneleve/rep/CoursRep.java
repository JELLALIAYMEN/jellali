package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Cours;
import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRep extends JpaRepository<Cours,Long> {
    public List<Cours>   findByProf(String prof, Trimestre trimestre);

}
