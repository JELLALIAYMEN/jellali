package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Classerep extends JpaRepository<Classe,Long> {



}
