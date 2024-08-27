package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Note;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Noterep extends JpaRepository<Note,Long> {
    public List<Note> findByEleveAndTrimestre(String code, Trimestre trimestre);
}
