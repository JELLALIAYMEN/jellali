package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Modepay;
import com.example.gstioneleve.entites.Statuspay;
import com.example.gstioneleve.entites.Typepay;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayementDTO {
    private double amount;
    private LocalDate date;

    @JsonProperty("typepay")
    private Typepay typepay;

    @JsonProperty("modepay")
    private Modepay modepay;

    @JsonProperty("statusPay")
    private Statuspay statusPay;

    private String file;
    private String filePath;

    @JsonProperty("eleve")
    private EleveDTO eleve; // Correction ici, pour utiliser EleveDTO au lieu de Eleve
}