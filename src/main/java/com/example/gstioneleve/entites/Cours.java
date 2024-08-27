package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String   nomCours;
    @Enumerated(EnumType.STRING)
    private Trimestre  trimestre;
    private  String code;
    @ManyToOne
    private  Eleve  eleve;
    @ManyToOne
    private  Prof prof;

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }
}
