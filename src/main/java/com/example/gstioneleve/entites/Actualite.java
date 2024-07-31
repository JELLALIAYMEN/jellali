package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Actualite {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long id;
    private  String Sujet;
    private Date date;

    @ManyToOne
    private  Eleve eleve;

}
