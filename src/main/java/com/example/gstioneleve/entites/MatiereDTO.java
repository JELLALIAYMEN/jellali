package com.example.gstioneleve.entites;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatiereDTO {
    private  Long matid;


    private String nom;
    private long eleveId;

    private double coefficient;

    private Option option;
}
