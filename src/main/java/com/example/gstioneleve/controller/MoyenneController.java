package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Service.Moyenneservice;
import com.example.gstioneleve.entites.Periode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoyenneController {
    @Autowired
    Moyenneservice Moyennesrviceimpl;
    @PostMapping("/saveMoyenne")
    public MoyenneDTO saveMoyenne(@RequestBody MoyenneDTO moyenneDTO) {

        return  Moyennesrviceimpl.saveMoyenne(moyenneDTO);
    }
//(sion veux  modifier  moyenne général ........ )
    @PutMapping("/Moyenne/{idmoy}")
    public MoyenneDTO updateMoyenne(
            @PathVariable("idmoy") Long idmoy,
            @RequestBody Double moyennevalue) {

        return Moyennesrviceimpl.updateMoyenne(moyennevalue, idmoy);
    }


/////////////////////////////////////////////a verifier//
//    @GetMapping("/periode/{code}")
//    public MoyenneDTO findByPeriodeAndCode(
//            @RequestParam("periode") Periode periode,
//            @PathVariable("code") String code) {
//        return Moyennesrviceimpl.findByPeriodeAndCode(periode, code);
//    }
//    @DeleteMapping("/{idMoyenne}")
    public void deleteMoyenne(@PathVariable("idMoyenne") Long idMoyenne) {
        Moyennesrviceimpl.deleteMoyenne(idMoyenne);
    }

    @GetMapping("/allmoy")
    public List<MoyenneDTO> getAllMoyennes() {
        return Moyennesrviceimpl.findAll();
    }

}
