package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.entites.*;

import java.util.List;


public interface Inoteservice {
   // List<NoteDTO> findByElllAndAndMatiere(Long idel, Long idmatiere);





  //  List<NoteDTO> findByElllAndAndMatiere(Long idel, Long idmatiere);

    NoteDTO save(NoteDTO noteDTO);
    List<NoteDTO> findByEleve_IdelAndid_matiereAndTrimestre(Long idel, Long id_matiere, Trimestre trimestre);

}


