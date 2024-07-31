package com.example.gstioneleve.entites;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;



import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eleve")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String firstname;
    private String secondname;

    @Enumerated(EnumType.STRING)
    private Cycle cycle;

    private String addrese;
    private String gmail;
    private String photo;

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    private List<Payement> payements;

    @OneToMany(mappedBy="eleve")
    private List<Moyenne> moyennes;



    @OneToMany(mappedBy="ell")
    private List<Discipline> disciplines;

    @OneToMany(mappedBy= "elevee")
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy="eleve")
    private List<Actualite> actualites;


    @OneToMany(mappedBy="elll", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<Note> notes;

    @ManyToMany
    @JoinTable(
            name = "eleve_matiere",
            joinColumns = @JoinColumn(name = "eleve_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private  List<Matiere> matieres;

    @PrePersist
    private void generateCode() {
        this.code = UUID.randomUUID().toString();
    }

}
