package com.example.gstioneleve.controller;
import com.example.gstioneleve.DTO.ActualiteDTO;
import com.example.gstioneleve.Service.ActualiteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; // pour l'injection de dépendances
import org.springframework.web.bind.annotation.*; // pour les annotations de contrôleur

@RestController

public class ActualiteController {

    @Autowired
    private ActualiteService actualiteService;

    @PostMapping("/save")
    public ActualiteDTO saveActualite(@RequestBody ActualiteDTO actualiteDTO) {
        return actualiteService.saveActualite(actualiteDTO);
    }

    @GetMapping("/all")
    public List<ActualiteDTO> findAllActualite() {
        return actualiteService.findAllActualite();
    }

    @DeleteMapping("/{id}")
    public void deleteActualiteById(@PathVariable Long id) {
        actualiteService.deleteActualiteById(id);
    }
}
