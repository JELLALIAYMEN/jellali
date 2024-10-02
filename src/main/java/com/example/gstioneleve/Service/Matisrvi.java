package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.entites.Matiere;

import java.util.Optional;

public interface Matisrvi {
    public Optional<Matiere> findById(Long idmatiere);


    MatiereDTO saveMatiere(MatiereDTO matiereDTO, Long id_classe);
}
