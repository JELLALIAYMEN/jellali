package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Service.MatiereService;
import com.example.gstioneleve.rep.Matiererep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @PostMapping("/savematiere")
    public MatiereDTO save(@RequestBody MatiereDTO matiereDTO) {
        return matiereService.saveMatiere(matiereDTO);
    }
}

