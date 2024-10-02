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

    private Long idel;

    private String code;
    private Double noteValue;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_note")
    private TypeNote typeNote;

    @Enumerated(EnumType.STRING)
    private Trimestre trimestre;


}
