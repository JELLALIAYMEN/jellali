package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.TypeDisc;
import lombok.Data;

@Data
public class DisciplineDTO {
    private  Long id;

    private TypeDisc typeDisc;
    private  String code;
}
