package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.ReclamationDTO;
import com.example.gstioneleve.Service.CoursService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoursController {
    @Autowired
    private CoursService CoursServiceimpl;

    @PostMapping("/savecours")
    public CoursDTO saveCours(@RequestBody CoursDTO coursDTO) {

        return CoursServiceimpl.saveCours(coursDTO);
    }

    @GetMapping("/{id}")
    public CoursDTO getCoursById(@PathVariable long id) {
        return CoursServiceimpl.findByid(id);

    }
    @PutMapping("/{id}")
    public void updateCours(@PathVariable long id, @RequestBody CoursDTO coursDTO) {
       CoursServiceimpl.update(id,coursDTO);
    }
}