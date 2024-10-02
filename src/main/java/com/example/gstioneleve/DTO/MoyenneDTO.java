package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.MoyenneType;
import com.example.gstioneleve.entites.Trimestre;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoyenneDTO {
  private Long idmoy; // Identifiant de la moyenne
  private Double moyennevalue; // Valeur de la moyenne
  private Trimestre trimestre; // Période associée à la moyenne
  private MoyenneType moyenneType;


  private String idel;

}
