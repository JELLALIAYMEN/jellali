package com.example.gstioneleve.entites;

import com.example.gstioneleve.DTO.EleveDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String file;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private Typepay typepay;

    @Enumerated(EnumType.STRING)
    private Statuspay statuspay;

    @Enumerated(EnumType.STRING)
    private Modepay modepay;

    @Enumerated(EnumType.STRING)
    private ModalitePay modalitePay;
    @ManyToOne


 Eleve eleve;
//    private  String FilePath;    @ManyToOne
//    @JoinColumn(name = "eleve_id")
//    private
}
