package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long matiereId;
    private String nom;
    @OneToMany(mappedBy="matiere", cascade = CascadeType.ALL)
    private List<Note> notes;

    @OneToMany(mappedBy="mat")
    private List<Prof> profs;
    @ManyToOne

    private Eleve el;


    @Enumerated(EnumType.STRING)
    private Option option;




    private double coefficient; // Coefficient de la matière


}