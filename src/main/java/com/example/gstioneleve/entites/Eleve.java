package com.example.gstioneleve.entites;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Eleve  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    private Trimestre trimestre;

    private String addresse;
    private String photo;
    private String firstname;
    private String secondname;
    private String gmail;

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    private List<Payement> payements;

    @OneToMany(mappedBy="el")
    private List<Matiere> matieres ;





    @OneToMany(mappedBy = "eleve")
    private List<Actualite> actualites;

    @OneToMany(mappedBy = "eleve")
    private List<Cours> cours;
@OneToMany(mappedBy = "ell")
private  List<Discipline> disciplines;
    @OneToMany(mappedBy="eleve")

    private List<Note> notes;
    @OneToMany(mappedBy="elevee")
    private  List<Reclamation> reclamations ;
    @OneToMany(mappedBy="El")
    private  List<Moyenne> moyennes ;



    @ManyToOne
    private Classe classe;



    @PrePersist
    private void generateCode() {
        this.code = UUID.randomUUID().toString();
    }
}

