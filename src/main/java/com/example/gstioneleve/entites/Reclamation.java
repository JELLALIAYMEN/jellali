package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String code;
    private  Date date;


    private String sujet; // Sujet de la réclamation
    private String resultat; // Détails de la réclamation


    @ManyToOne


    private Eleve elevee ;
}
