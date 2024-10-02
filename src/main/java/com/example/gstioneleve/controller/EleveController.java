package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.EleveDTO;
import com.example.gstioneleve.Service.Iservice;
import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Niveau;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



@RestController
public class EleveController {
    private static final Logger logger = LoggerFactory.getLogger(EleveController.class);
    @Autowired

    private Iservice IserviceImpl;
    @GetMapping("/eleves")
    public List<EleveDTO> findAll() {
        return IserviceImpl.findAll();
    }



    @PostMapping(path = "/saveleve", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveEleve(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("firstname") String firstname,
            @RequestParam("secondname") String secondname,
            @RequestParam("gmail") String gmail,
            @RequestParam("niveau") String niveauStr, // Reçoit le niveau comme chaîne
            @RequestParam("addresse") String addresse,
            @RequestParam("idClasse") Long id_classe

    ) {
        try {
            Niveau niveau;
            try {
                niveau = Niveau.valueOf(niveauStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                logger.error("Invalid Niveau value: {}", niveauStr, e);
                // Optionnel : définir une valeur par défaut
                niveau = Niveau.SEPT; // Remplacez avec une valeur par défaut si applicable
            }

            EleveDTO eleveDTO = IserviceImpl.saveEleve(photo, firstname, secondname, gmail, niveau, addresse, id_classe);
            return ResponseEntity.ok(eleveDTO);

        } catch (IOException e) {
            logger.error("Error processing file upload: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing file upload: " + e.getMessage());
        } catch (RuntimeException e) {
            logger.error("Error saving student: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error saving student: " + e.getMessage());
        }
    }


    @DeleteMapping("/el/{id}")
    public void deleteEleve(@PathVariable Long id) {
      IserviceImpl.deleteEleve(id);
    }



    @Autowired
    public void setIserviceimpl(Iservice iserviceimpl) {
        this.IserviceImpl = iserviceimpl;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable("id") Long id,@RequestHeader("LoggedInUser") String username) {
        System.out.println("logged in user details :  -" +username);
        Eleve eleve = IserviceImpl.findById(id);
        if (eleve == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Renvoie 404 si l'élève n'est pas trouvé
        }
        return ResponseEntity.ok(eleve); // Renvoie 200 OK avec l'élève trouvé
    }


}