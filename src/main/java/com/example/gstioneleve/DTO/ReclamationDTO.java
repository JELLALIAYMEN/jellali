package com.example.gstioneleve.DTO;


import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Data
public class ReclamationDTO {
    private Long id;
    private String sujet;     // Sujet de la réclamation
    private String resultat;  // Détails de la réclamation
    private Date date;        // Date de la réclamation
    private String code;

}
