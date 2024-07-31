package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Exp.MissingExamControl2Exception;
import com.example.gstioneleve.Service.Inoteservice;
import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.entites.Periode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    Inoteservice inoteserviceimple;


    @PostMapping("/saveNote")
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO) {
        return inoteserviceimple.saveNote(noteDTO);

    }

    @PostMapping("/saveMat")
    public MatiereDTO saveMatiere(@RequestBody MatiereDTO matiereDTO) {

        return inoteserviceimple.saveMatiere(matiereDTO);
    }


    @ExceptionHandler(MissingExamControl2Exception.class)
    public ResponseEntity<String> handleMissingExamControl2Exception(MissingExamControl2Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/updateNote/{id}")
    public NoteDTO updateNote(@PathVariable Long id, @RequestBody NoteDTO noteDTO) {
        return inoteserviceimple.updateNote(id, noteDTO);
    }


   }
