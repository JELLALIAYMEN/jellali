package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private Date date;


    private String sujet; // Sujet de la réclamation
    @Enumerated(EnumType.STRING)
    private ResultatRéclamation resultatRéclamation; // Détails de la réclamation
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;



}
