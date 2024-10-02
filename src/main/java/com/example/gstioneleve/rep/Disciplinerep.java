package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Disciplinerep extends JpaRepository<Discipline,Long> {
    public List<Discipline> findByCode(String Code);
}
