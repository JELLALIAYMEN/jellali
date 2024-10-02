package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Modepay;
import com.example.gstioneleve.entites.Statuspay;
import com.example.gstioneleve.entites.Typepay;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayementDTO {
    private Long id;
    private double amount;

    private LocalDate date;

    private Typepay typepay;

    @Enumerated(EnumType.STRING)
    private Modepay modepay;

    @Enumerated(EnumType.STRING)
    private Statuspay statusPay;

    private String code;

    private String file;



     // Correction ici, pour utiliser EleveDTO au lieu de Eleve
}