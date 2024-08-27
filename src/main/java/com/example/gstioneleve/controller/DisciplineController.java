package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.DisciplineDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.Service.DisciplineService;
import com.example.gstioneleve.entites.Trimestre;
import com.example.gstioneleve.entites.TypeDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplineController {
    @Autowired
    DisciplineService disciplineServiceimpl;
    @Autowired
    Mapperdto dto;

    @PostMapping("/saveDiscipline")
    public DisciplineDTO saveDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        return disciplineServiceimpl.saveDiscipline(disciplineDTO);

    }
    @PutMapping("/discipline/{id}")
    public DisciplineDTO updateDiscipline(
            @PathVariable Long id,
            @RequestParam TypeDisc typeDisc) {

        return disciplineServiceimpl.updateDiscipline(id, typeDisc);
    }

    @GetMapping("/findByCode")
    public List<DisciplineDTO> findByCode(@RequestParam String code) {
        return disciplineServiceimpl.findByCode(code);
    }
    @DeleteMapping("/discipline/{id}")
    public void deleteDiscipline(@PathVariable Long id) {
       disciplineServiceimpl.deleteDiscipline(id);}
    @GetMapping("/alldiscipline")
        public List<DisciplineDTO> findAll(){
        return disciplineServiceimpl.findAll();
    }


    @GetMapping("/disciplinefindByCode")
    public List<DisciplineDTO>findByCodeAndTrimestre (@RequestParam String code, @RequestParam Trimestre trimestre) {
        return disciplineServiceimpl.findByCodeAndTrimestre(code,trimestre);
    }

}