package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.Date;

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
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;
    @Override
    public String toString() {
        return "Payement{" +
                "id=" + id +
                ", amount=" + amount +
                ", eleve=" + (eleve != null ? eleve.getIdel() : null) + // Évitez d'afficher l'objet `Eleve` directement
                '}';
    }

}
