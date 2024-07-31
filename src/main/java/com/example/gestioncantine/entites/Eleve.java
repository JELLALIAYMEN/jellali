package com.example.gestioncantine.entites;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long id;
    private String nom;
    private  String code;
    private String prenom;

    private  String gmail ;
    @OneToOne
    private  Menu menu;

}
