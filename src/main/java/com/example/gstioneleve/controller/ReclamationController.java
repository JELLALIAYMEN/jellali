package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.ReclamationDTO;
import com.example.gstioneleve.Service.ReclamationSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReclamationController {
    @Autowired
    ReclamationSevice reclamationServiceimpl;

    @PostMapping("/saveReclamation")
    public ReclamationDTO saveReclamation(@RequestBody ReclamationDTO reclamationDTO) {
        // Call the service to save the reclamation
        return reclamationServiceimpl.saveReclamation(reclamationDTO);
    }
//
//    @PostMapping("/saveReclamation")
//    public ReclamationDTO savereclamation(@RequestBody ReclamationDTO reclamationDTO) {
//
//        return reclamationServiceimpl.savereclamation(reclamationDTO);
//    }

    // ReclamationController
    @PutMapping("/reclamations/{id}")
    public ReclamationDTO updateReclamation(@RequestParam String resulatat, @PathVariable Long id) {
        return reclamationServiceimpl.updateReclamation(resulatat, id);
    }

    @GetMapping("/reclamations/{code}")
    public List<ReclamationDTO> findByEleve_Code(@PathVariable String code){
      return  reclamationServiceimpl.findByEleve_Code(code);

}
    @DeleteMapping("/reclamations/{id}")
    public void deleteReclamation(@PathVariable Long id) {
      reclamationServiceimpl.deleteReclamation(id); // Appel à votre service pour supprimer la réclamation par ID
    }


}