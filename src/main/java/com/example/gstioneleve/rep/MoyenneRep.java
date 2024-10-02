package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Moyenne;
import com.example.gstioneleve.entites.MoyenneType;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoyenneRep  extends JpaRepository<Moyenne,Long> {


  //  List<Moyenne> findByidelAndTrimestreAndMoyenneType (Long idel , Trimestre trimestre , MoyenneType moyenneType);

   // MoyenneDTO findByPeriodeAndCode(Periode periode, String code);

   // List<Moyenne> findByEleve_CodeAndTrimestre(String code, Trimestre trimestre);
   // public  Moyenne findByEleve_IdelAndTrimestreAndTrimestre()
   Moyenne findByEleveAndTrimestre(Eleve eleve  , Trimestre trimestre) ;
   List<Moyenne> findByEleveAndMoyenneType (Eleve eleve , MoyenneType moyenneType);




}
