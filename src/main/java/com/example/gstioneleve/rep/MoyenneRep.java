package com.example.gstioneleve.rep;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Moyenne;
import com.example.gstioneleve.entites.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoyenneRep  extends JpaRepository<Moyenne,Long> {
   // MoyenneDTO findByPeriodeAndCode(Periode periode, String code);





}
