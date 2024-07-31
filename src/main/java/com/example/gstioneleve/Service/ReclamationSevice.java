package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ReclamationDTO;

import java.util.List;

public interface ReclamationSevice {
    ReclamationDTO savereclamation(ReclamationDTO reclamationDTO);

    ReclamationDTO updateReclamation(String sujet, Long id);

    List<ReclamationDTO> findByCode(String code);

    void deleteReclamation(Long id);
}
