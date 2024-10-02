package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.entites.Trimestre;

import java.util.List;

public interface Moyenneservice {
    public  MoyenneDTO saveMoyenne(MoyenneDTO moyenneDTO);



   // public abstract MoyenneDTO updateMoyenne(Double moyennevalue, Long idmoy );


   // MoyenneDTO findByPeriodeAndCode(Periode periode, String code);
    public abstract void  deleteMoyenne(Long idMoyenne);

    //public MoyenneDTO calculerMoyenneTrimestrielle(String codeEleve, Trimestre trimestre) ;
   // public double calculerMoyenneTrimestrielleParMatiere(String codeEleve, Matiere matiere, Trimestre trimestre);




    //double calculerMoyenneTrimestrielleParMatiere(String code, Matiere matiere, Trimestre trimestre);

    double calculerMoyenneTrimestrielleParMatiere(Long eleveId, Long matiereId, Trimestre trimestre);
    public double calculerMoyenneTrimestrielleParEleve(Long idel, Trimestre trimestre);
    public double calculerMoyenneAnnuelle(Long eleveId);
}
