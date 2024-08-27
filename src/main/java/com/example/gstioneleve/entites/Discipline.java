package com.example.gstioneleve.entites;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeDisc typeDisc;
    private LocalDate date;
    @Transient
    private String code;
    @Enumerated(EnumType.STRING)
    private  Trimestre  trimestre;

    @ManyToOne
    @JoinColumn(name = "eleve_id") // Ajoutez cette ligne pour spécifier la colonne de jointure
    private Eleve ell;
}
