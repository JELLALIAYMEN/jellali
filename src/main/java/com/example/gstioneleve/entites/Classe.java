package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Classe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_classe;

    private String nom;


    @OneToMany(mappedBy= "classe", cascade = CascadeType.ALL)
    private List<Eleve> eleves;


    public Long getId_classe() {
        return id_classe;
    }
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matiere> matieres = new ArrayList<>();

}






