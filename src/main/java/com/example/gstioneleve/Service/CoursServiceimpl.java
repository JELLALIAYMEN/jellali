package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Cours;
import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.Trimestre;
import com.example.gstioneleve.entites.TypeCours;
import com.example.gstioneleve.rep.CoursRep;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.gstioneleve.entites.TypeCours.*;

@Service
public class CoursServiceimpl implements  CoursService{
    @Autowired
    CoursRep coursRep;
    @Autowired
    Mapperdto dto;


    @Override
    public CoursDTO saveCours(CoursDTO coursDTO) {
        // Convertir le CoursDTO en entité Cours
        Cours cours = dto.fromCoursDTO(coursDTO);

        // Sauvegarder l'entité Cours dans le repository
        Cours savedCours = coursRep.save(cours);

        // Convertir l'entité Cours sauvegardée en CoursDTO
        return dto.fromCours(savedCours);
    }

    @Override
    public List<CoursDTO> findByProf(String prof, Trimestre trimestre) {
     if(prof.equals(prof) || trimestre.equals(trimestre)){
         List<Cours> coursList=coursRep.findByProf(prof, trimestre);
         return coursList.stream()
                 .map(cours -> dto.fromCours(cours))
                 .collect(Collectors.toList());

     }
     return  null;
    }


    @Override
    public CoursDTO findByid(long id) {
      Cours cours=coursRep.findById(id).orElse(null);
      coursRep.save(cours);
      return  dto.fromCours(cours);
    }

    @Override
    public void update(long id, CoursDTO coursDTO) {
        Cours cours = coursRep.findById(id).orElse(null);

        if (cours != null) {
            cours.setCode(coursDTO.getCode());
            cours.setNomCours(coursDTO.getNomCours());
            coursRep.save(cours);
        } else {
            // Handle the case where the entity is not found.
            // You might want to throw an exception or handle it according to your application's needs.
            throw new EntityNotFoundException("Cours with ID " + id + " not found.");
        }
}}
