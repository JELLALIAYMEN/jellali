package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.ClasseDTO;
import com.example.gstioneleve.Service.Classeser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClasseController {
    @Autowired
    Classeser ClasseSeimpl;
    @PostMapping("/saveclass")
    public ClasseDTO save(@RequestBody ClasseDTO classeDTO)  {

        return ClasseSeimpl.saveClasse(classeDTO);
    }
}
