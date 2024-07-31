package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnote;

    private Double noteControleContinue;
    private Double noteexamencontrole1;
    private Double noteexamencontrole2;
    private Double noteeexamenSynthése;
    private String code;
    private Long idmatiere;


    @ManyToOne
    @JoinColumn(name = "eleve_id") // Assurez-vous que ce nom est unique
    private Eleve elll;


    private Long id;

    @ManyToOne
    @JoinColumn(name = "matiere_id") // Assurez-vous que ce nom est unique
    private Matiere matiere;

    @Enumerated(EnumType.STRING)
    @Column(name = "periode")
    private Periode periode;
}
