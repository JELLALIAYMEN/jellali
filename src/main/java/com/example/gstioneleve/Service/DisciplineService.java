package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.DisciplineDTO;
import com.example.gstioneleve.entites.TypeDisc;

import java.util.List;

public interface DisciplineService {

    DisciplineDTO saveDiscipline(DisciplineDTO disciplineDTO);

    DisciplineDTO updateDiscipline(Long id, TypeDisc typeDisc);

    List<DisciplineDTO> findByCode(String code);
    void deleteDiscipline(Long id);
    List<DisciplineDTO> findAll();
}
