package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.EleveDTO;
import com.example.gstioneleve.Service.Iservice;
import com.example.gstioneleve.entites.Option;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



@RestController

public class EleveController {
    @Autowired
    private Iservice  IserviceImpl;
    @Autowired


    @GetMapping("/eleves")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EleveDTO> findAll() {

        return IserviceImpl.findAll();
    }

    @PostMapping(path = "/saveleve", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EleveDTO saveEleve(@RequestParam MultipartFile photo, String firstname, String secondname, String gmail, String addresse, Option option) throws IOException {
        return IserviceImpl.saveEleve(photo,firstname,secondname,gmail,addresse);


    }

    @DeleteMapping("/{id}")
    public void deleteEleve(@PathVariable Long id) {
      IserviceImpl.deleteEleve(id);
    }
    @GetMapping("/{code}")
    public EleveDTO getEleveByCode(@PathVariable String code) {
        EleveDTO eleveDTO = IserviceImpl.findByCode(code);
        if (eleveDTO != null) {
            return eleveDTO;
        } else {
            // Retourner une réponse nulle ou gérer l'exception selon le besoin
            throw new IllegalArgumentException("Élève non trouvé avec le code : " + code);
        }
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return  authentication;
    }

}