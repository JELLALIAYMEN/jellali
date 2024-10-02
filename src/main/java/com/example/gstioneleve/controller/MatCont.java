package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.Service.Matisrvi;
import com.example.gstioneleve.Service.Moyenneservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatCont {
    @Autowired
    Matisrvi Matsrvicimpl;
    @PostMapping("/save/saveMat/{id_classe}")
    public MatiereDTO saveMatiere(@Valid @RequestBody MatiereDTO matiereDTO, @PathVariable Long id_classe) {
        return Matsrvicimpl.saveMatiere(matiereDTO, id_classe);
    }





}
