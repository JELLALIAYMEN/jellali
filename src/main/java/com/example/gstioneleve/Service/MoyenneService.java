package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.entites.Moyenne;
import com.example.gstioneleve.entites.Trimestre;

import java.util.List;

public interface MoyenneService {
    public MoyenneDTO calculerMoyenneTrimestrielle(Long eleveId, Trimestre trimestre);
    public MoyenneDTO calculerMoyenneAnnuelle(Long eleveId);
    public void update(long id, MoyenneDTO moyenneDTO);
    public List<MoyenneDTO> findByEl(String code);
}
