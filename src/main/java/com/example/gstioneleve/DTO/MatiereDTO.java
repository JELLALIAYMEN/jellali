package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Option;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MatiereDTO {
    private Long matiereId;

    private String nom;
    private  double coffécient;

    @Enumerated(EnumType.STRING)
    private  Option option;

}

