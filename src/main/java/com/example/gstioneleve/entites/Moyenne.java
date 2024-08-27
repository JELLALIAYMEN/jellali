package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Moyenne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToOne
    private Matiere matiere;
    private  double moyennevalue;
    @Enumerated(EnumType.STRING)
    private  MoyenneType moyenneType;
    @ManyToOne
    private  Eleve El;

}
