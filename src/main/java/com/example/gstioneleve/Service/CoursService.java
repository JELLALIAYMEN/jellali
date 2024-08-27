package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.entites.Cours;
import com.example.gstioneleve.entites.Trimestre;

import java.util.List;

public interface CoursService {


    public CoursDTO findByid(long id);
    public  void update(long id,CoursDTO  coursDTO);
    public CoursDTO saveCours(CoursDTO coursDTO);
    public List<CoursDTO>   findByProf(String prof, Trimestre trimestre);
}
