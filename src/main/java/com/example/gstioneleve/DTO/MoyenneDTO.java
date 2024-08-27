package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.entites.MoyenneType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoyenneDTO {
    private Long id;
    private Long matiereId; // Peut être null si c'est une moyenne globale
    private String code;
    private double moyennevalue;
    @Enumerated(EnumType.STRING)
    private MoyenneType moyenneType;

}