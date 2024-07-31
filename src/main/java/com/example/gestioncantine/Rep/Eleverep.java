package com.example.gestioncantine.Rep;

import com.example.gestioncantine.entites.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Eleverep extends JpaRepository<Eleve,Long> {
    Eleve findByCode(String code);
}
