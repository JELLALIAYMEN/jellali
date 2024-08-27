package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Service.MoyenneService;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoyenneController {
    @Autowired
    MoyenneService MoyenneServiceimpl;

    @PostMapping("/trimestrielle")
    public ResponseEntity<MoyenneDTO> getMoyenneTrimestrielle(
            @RequestParam Long eleveId,
            @RequestParam Trimestre trimestre) {

        // Validation des paramètres
        if (eleveId == null || trimestre == null) {
            return ResponseEntity.badRequest().body(null); // 400 Bad Request
        }

        try {
            MoyenneDTO moyenneDTO = MoyenneServiceimpl.calculerMoyenneTrimestrielle(eleveId, trimestre);

            // Vérifiez si la moyenneDTO est bien construite
            if (moyenneDTO == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null); // 500 Internal Server Error
            }

            // Retournez la réponse avec l'objet moyenneDTO
            return ResponseEntity.ok(moyenneDTO);
        } catch (Exception e) {
            e.printStackTrace(); // Afficher l'erreur dans les logs pour le débogage
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // 500 Internal Server Error
        }
    }

    @PostMapping("/annuelle")
    public ResponseEntity<MoyenneDTO> getMoyenneAnnuelle(@RequestParam Long eleveId) {
        try {
            // Appel de la méthode de calcul de la moyenne annuelle
            MoyenneDTO moyenneDTO = MoyenneServiceimpl.calculerMoyenneAnnuelle(eleveId);
            return ResponseEntity.ok(moyenneDTO);
        } catch (Exception e) {
            e.printStackTrace(); // Loguer l'erreur pour le débogage
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public void updateMoyenne(
            @PathVariable("id") long id,
            @RequestBody MoyenneDTO moyenneDTO) {

        MoyenneServiceimpl.update(id, moyenneDTO);
    }
    @GetMapping("/notefindByCode")
    public List<MoyenneDTO> findByCode(@RequestParam String code){
        return  MoyenneServiceimpl.findByEl(code);
    }
}