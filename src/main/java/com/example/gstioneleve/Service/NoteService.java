package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.DisciplineDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.entites.Note;
import com.example.gstioneleve.entites.Trimestre;

import java.util.List;

public interface NoteService {
    public NoteDTO save(NoteDTO noteDTO);
    public void update(long id, NoteDTO noteDTO);
    public NoteDTO findByid(long id);
    public List<NoteDTO> findByEleveAndTrimestre(String code, Trimestre trimestre);

}
