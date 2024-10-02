package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Actualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface Actualiterep  extends JpaRepository<Actualite,Long> {
}
