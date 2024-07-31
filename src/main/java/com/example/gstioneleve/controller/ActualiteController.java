package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.ActualiteDTO;
import com.example.gstioneleve.DTO.DisciplineDTO;
import com.example.gstioneleve.Service.ActualiteService;
import com.example.gstioneleve.entites.Actualite;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ActualiteController {
    @Autowired
    ActualiteService Actualiteserviceimpl;

    @PostMapping("/saveActualite")
    public ActualiteDTO saveActualite(@RequestBody ActualiteDTO actualiteDTO) {

        return Actualiteserviceimpl.saveActualite(actualiteDTO);

    }

    @GetMapping("/allActualite")
    public List<ActualiteDTO> findAllActualite() {
        return Actualiteserviceimpl.findAllActualite();

    }
    @DeleteMapping("/ac/{id}")
    public void deleteActualiteById(@PathVariable Long id) {
       Actualiteserviceimpl.deleteActualiteById(id);
    }
}