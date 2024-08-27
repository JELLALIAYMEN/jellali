package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Trimestre;
import com.example.gstioneleve.entites.TypeNote;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("typeNote")
    private TypeNote typeNote;

    @JsonProperty("valeur")
    private double valeur;

    @JsonProperty("trimestre")
    private Trimestre trimestre;

    @JsonProperty("eleveId") // ID de l'élève
    private Long eleveId;

    @JsonProperty("matiereId") // ID de la matière
    private Long matiereId;
}
