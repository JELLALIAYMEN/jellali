package com.example.gestioncantine.entites;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long idmenu;
    private  String nomplatprincipal;
    private  String  nomplatDessert;
    private String nomplatentré;
    private  String code;
    @Enumerated(EnumType.STRING)
    private Typemenucommandé typemenucommandé;
    @OneToOne

    Eleve eleve;
}
