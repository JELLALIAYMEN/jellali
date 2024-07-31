package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Moyenne;
import com.example.gstioneleve.entites.Periode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoyenneDTO {
  private Long idmoy; // Identifiant de la moyenne
  private Double moyennevalue; // Valeur de la moyenne
  private Periode periode; // Période associée à la moyenne


  private String code;

}
