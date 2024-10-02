package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Service.Inoteservice;
import com.example.gstioneleve.Service.Matisrvi;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    Inoteservice inoteserviceimple;
    @Autowired
    Matisrvi Matsrvicimpl;







    @GetMapping("/code/{idel}/{idmatiere}/{trimestre}")
    public ResponseEntity<List<NoteDTO>> findByEleve_IdelAndMatiere_idmatiereAndTrimestre(
            @PathVariable("idel") Long eleveId,
            @PathVariable("id_matiere") Long id_matiere,
            @PathVariable("trimestre") Trimestre trimestre) {

        List<NoteDTO> notes = inoteserviceimple.findByEleve_IdelAndid_matiereAndTrimestre(eleveId, id_matiere, trimestre);

        // Retourner 404 Not Found si aucune note n'est trouvée
        if (notes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Retourner 200 OK avec la liste des notes
        return ResponseEntity.ok(notes);
    }

////

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getMatiereById(@PathVariable("id_matiere") Long id_matiere) {
        return  Matsrvicimpl.findById(id_matiere)
                .map(matiere -> ResponseEntity.ok().body(matiere)) // Renvoie 200 OK avec la matière
                .orElseGet(() -> ResponseEntity.notFound().build()); // Renvoie 404 Not Found si non trouvée
    }


    @PostMapping("/saveN")
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO) {

        return inoteserviceimple.save(noteDTO);
    }

}
////




