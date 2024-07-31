package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.EleveDTO;
import com.example.gstioneleve.Service.Iservice;
import com.example.gstioneleve.entites.Cycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:64329")

@RestController
public class EleveController {
    @Autowired
    private Iservice  IserviceImpl;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/eleves`")
    public List<EleveDTO> findAll() {
        return IserviceImpl.findAll();
    }

    @PostMapping(path = "/saveleve", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EleveDTO saveEleve(@RequestParam MultipartFile photo, String firstname, String secondname, String gmail, Cycle cycle,String addresse) throws IOException {
        return IserviceImpl.saveEleve(photo,firstname,secondname,gmail,cycle,addresse);


    }

    @DeleteMapping("/{id}")
    public void deleteEleve(@PathVariable Long id) {
      IserviceImpl.deleteEleve(id);
    }

}