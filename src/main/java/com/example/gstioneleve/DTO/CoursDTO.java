package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.TypeCours;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  CoursDTO{

    private  Long id;
    private  String   nomCours;
    private  String code;

    @JsonProperty("typepay")
    private TypeCours typeCours;

}
