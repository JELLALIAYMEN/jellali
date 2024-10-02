package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.Service.Moyenneservice;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.entites.Trimestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoyenneController {
    @Autowired
    Moyenneservice   MoyenneServiceimpl;

//    @PostMapping("/saveMoyenne")
//    public MoyenneDTO saveMoyenne(@RequestBody MoyenneDTO moyenneDTO) {
//
//        return  MoyenneServiceimpl.saveMoyenne(moyenneDTO);
//    }
//(sion veux  modifier  moyenne général ........ )
//    @PutMapping("/Moyenne/{idmoy}")
//    public MoyenneDTO updateMoyenne(
//            @PathVariable("idmoy") Long idmoy,
//            @RequestBody Double moyennevalue) {
//
//        return MoyenneServiceimpl.updateMoyenne(moyennevalue, idmoy);
//    }



//    }
//    @DeleteMapping("/{idMoyenne}")
    public void deleteMoyenne(@PathVariable("idMoyenne") Long idMoyenne) {
        MoyenneServiceimpl.deleteMoyenne(idMoyenne);
    }


   @GetMapping ("/codeEleve/{idmatiere}{trimestre}")
   public double calculerMoyenneTrimestrielleParMatiere(Long  idel, Long matiereId, Trimestre trimestre){
  // public double calculerMoyenneTrimestrielleParMatiere(String codeEleve, Long idmatiere, Trimestre trimestre){
        return MoyenneServiceimpl.calculerMoyenneTrimestrielleParMatiere( idel, matiereId, trimestre);

    }
//    @GetMapping("/eleve/{eleveId}/trimestre/{trimestre}")
//    public double calculerMoyenneTrimestrielleParEleve(
//            @PathVariable Long idel,
//            @PathVariable Trimestre trimestre) {
//
//
//        // Appel au service pour calculer la moyenne
//        return MoyenneServiceimpl.calculerMoyenneTrimestrielleParEleve(idel, trimestre);
//    }
    @GetMapping("/eleve/{idel}/annuelle")
    public double calculerMoyenneAnnuelle(@PathVariable Long  idel) {
        // Appel au service pour calculer la moyenne annuelle
        return MoyenneServiceimpl.calculerMoyenneAnnuelle( idel);
    }
    @GetMapping("/eleve/{idel}/trimestre/{trimestre}")
    public double calculerMoyenneTrimestrielleParEleve(
            @PathVariable Long  idel,
            @PathVariable("trimestre") Trimestre trimestre) {

        try {
            trimestre = Trimestre.valueOf(trimestre.toString());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid trimestre: " + trimestre);
        }
        return MoyenneServiceimpl.calculerMoyenneTrimestrielleParEleve(idel, trimestre);
    }
    @PostMapping("/saveMoy")
    public MoyenneDTO saveMoyenne(@RequestBody MoyenneDTO moyenneDTO) {
        try {
            // Appel du service pour sauvegarder la moyenne
            return MoyenneServiceimpl.saveMoyenne(moyenneDTO);
        } catch (Exception e) {
            // Retourne un DTO vide ou un autre type de réponse en cas d'erreur
            return null; // Vous pouvez personnaliser cette réponse en fonction de vos besoins
        }
    }

}
