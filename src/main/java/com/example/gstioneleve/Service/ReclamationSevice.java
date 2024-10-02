package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ReclamationDTO;

import java.util.List;

public interface ReclamationSevice {
    public ReclamationDTO saveReclamation(ReclamationDTO reclamationDTO);
                                                       // public ReclamationDTO savereclamation(ReclamationDTO reclamationDTO);

   // ReclamationDTO savereclamation(ReclamationDTO reclamationDTO);

    ReclamationDTO updateReclamation(String sujet, Long id);
    List<ReclamationDTO> findByEleve_Code(String code);



    void deleteReclamation(Long id);
}
