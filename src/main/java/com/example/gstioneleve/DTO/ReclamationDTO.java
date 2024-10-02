package com.example.gstioneleve.DTO;


import com.example.gstioneleve.entites.ResultatRéclamation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReclamationDTO {
    private Long id;
    private String sujet;     // Sujet de la réclamation
  // Détails de la réclamation
    private Date date;
    @Enumerated(EnumType.STRING)
    private ResultatRéclamation resultatRéclamation;
    private String code;

}
