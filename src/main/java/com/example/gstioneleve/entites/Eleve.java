package com.example.gstioneleve.entites;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;



import lombok.Data;

import java.util.List;
import java.util.UUID;



import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "payments")

public class Eleve   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idel;
    private String firstname;
    private String secondname;
    private String addrese;
    private String gmail;
    @Column(unique = true)
    private String code;



    @Enumerated(EnumType.STRING)
    private Niveau niveau;



    private String photo;

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    private List<Payement> payements;

    @OneToMany(mappedBy = "eleve")
    private List<Moyenne> moyennes;

    @OneToMany(mappedBy = "eleve")
    private List<Discipline> disciplines;

    @OneToMany(mappedBy = "eleve")
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy = "eleve")
    private List<Actualite> actualites;

    @OneToMany(mappedBy = "eleve")
    private List<Note> notes;

    @ManyToOne
    @JoinColumn(name = "id_classe", nullable = false)
    private Classe classe;

    public String generateCode() {
     return   this.code = UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
        return "Eleve{" +
                "id=" + idel +
                ", nom='" + firstname + '\'' +
                // Évitez de référencer des collections de type `Payement` directement ici
                '}';
    }


    // Getters and setters
}
