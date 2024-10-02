package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Payement;
import com.example.gstioneleve.entites.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Reclamationep extends JpaRepository<Reclamation
        ,Long> {
    List<Reclamation> findByEleve_Code(String code);

}
