package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "matiere")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasse;
    private String nomClasse;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    private List<Matiere> matieresEnseignees;
    @OneToMany(mappedBy="classe")
    private List<Eleve> eleves;
    private List<Prof> profs;
}
