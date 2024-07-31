package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Matiere {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idmatiere;
    private   String    nom;
  @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes;


}
