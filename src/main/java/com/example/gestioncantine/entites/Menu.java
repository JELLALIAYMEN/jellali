package com.example.gestioncantine.entites;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    @Enumerated(EnumType.STRING)
    private Typemenucommandé typemenucommandé;
 private Long idel;







}
