package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Moyenne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoyenneRep extends JpaRepository<Moyenne,Long> {
    public List<Moyenne> findByEl(String code);
}
