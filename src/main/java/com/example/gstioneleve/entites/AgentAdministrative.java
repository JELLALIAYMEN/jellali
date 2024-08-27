package com.example.gstioneleve.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAdministrative  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String addresse;

    private String firstname;
    private String secondname;
    private String gmail;
}