package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Matiere {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_matiere;

  private Double coff;
  private String nom;

  @ManyToOne
  private  Eleve eleve;
  @ManyToOne
  @JoinColumn(name = "classe_id", nullable = false)
  private Classe classe;

  public Long getId() {
    return id_matiere;
  }
}
