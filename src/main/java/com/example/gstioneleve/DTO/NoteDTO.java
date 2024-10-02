package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Trimestre;
import com.example.gstioneleve.entites.TypeNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {

    private Long idnote;
    private Long id_matiere;
    private Long idel;
    private TypeNote typeNote;
    private Double noteValue;
    private Trimestre trimestre;
}
