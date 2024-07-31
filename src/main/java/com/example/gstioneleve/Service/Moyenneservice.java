package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.entites.Periode;

import java.util.List;

public interface Moyenneservice {
    public abstract MoyenneDTO saveMoyenne(MoyenneDTO moyenneDTO);



    public abstract MoyenneDTO updateMoyenne(Double moyennevalue, Long idmoy );


   // MoyenneDTO findByPeriodeAndCode(Periode periode, String code);
    public abstract void  deleteMoyenne(Long idMoyenne);
List<MoyenneDTO> findAll();



}
