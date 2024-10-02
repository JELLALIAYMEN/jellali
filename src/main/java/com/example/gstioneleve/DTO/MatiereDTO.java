package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Classe;
import com.example.gstioneleve.entites.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatiereDTO {

    private Long id_matiere;

    private String nom;
    private Double coff;





}
