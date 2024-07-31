package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.entites.*;

import java.util.List;


public interface Inoteservice {
public NoteDTO saveNote(NoteDTO noteDTO);



    public NoteDTO updateNote(Long idnote, NoteDTO noteDTO) ;


    MatiereDTO saveMatiere(MatiereDTO matiereDTO);
   // List<NoteDTO> findByCodeAndMatiereAndPeriode(String code,Matiere matiere,Periode periode);

}


