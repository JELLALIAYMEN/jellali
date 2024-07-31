package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ActualiteDTO;

import java.util.List;

public interface ActualiteService {
    ActualiteDTO  saveActualite(ActualiteDTO actualiteDTO);
    List<ActualiteDTO>  findAllActualite();
 void  deleteActualiteById(Long id);

}
