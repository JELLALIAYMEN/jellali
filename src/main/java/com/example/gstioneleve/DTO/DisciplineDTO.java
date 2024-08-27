package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.Trimestre;
import com.example.gstioneleve.entites.TypeDisc;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DisciplineDTO {
    private  Long id;
    private LocalDate date;
    private TypeDisc typeDisc;
    private  String code;
    @JsonProperty("trimestre")
    private Trimestre trimestre;
}
