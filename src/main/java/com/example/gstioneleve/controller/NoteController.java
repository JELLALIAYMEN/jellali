package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.DisciplineDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Service.NoteService;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    NoteService NoteServiceimpl;

    @PostMapping("/savenote")
    public NoteDTO save(@RequestBody NoteDTO noteDTO) {
        return NoteServiceimpl.save(noteDTO); // Appel au service pour sauvegarder la note
    }

    @PutMapping("/{id}")
    public void updateNote(
            @PathVariable("id") long id,
            @RequestBody NoteDTO noteDTO) {

        NoteServiceimpl.update(id, noteDTO);
    }
    @GetMapping("/{id}")
    public NoteDTO getNoteById(@PathVariable("id") long id) {
       return   NoteServiceimpl.findByid(id);
}

    @GetMapping("/notefindByCode")
    public List<NoteDTO> findByCode(@RequestParam String code, @RequestParam Trimestre trimestre) {
        return NoteServiceimpl.findByEleveAndTrimestre(code, trimestre);
    }
}