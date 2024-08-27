package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Disciplinerep extends JpaRepository<Discipline,Long> {

    List<Discipline> findByEll_Code(String code);
    List<Discipline> findByCodeAndTrimestre(String code, Trimestre trimestre);
}
