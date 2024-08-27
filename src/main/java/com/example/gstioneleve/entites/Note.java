package com.example.gstioneleve.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Utiliser id comme identifiant principal

    @Enumerated(EnumType.STRING)
    private TypeNote typeNote;  // Type de note (Contrôle, Examen, etc.)

    private double valeur;

    @Enumerated(EnumType.STRING)
    private Trimestre trimestre;

    @ManyToOne
    @JoinColumn(name = "eleve_id")

    // Colonne pour la clé étrangère vers Eleve
    private Eleve eleve;  // Référence à l'élève qui a reçu la note

    @ManyToOne

    private Matiere matiere; // Référence à la matière
}
