package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.*;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

public class EleveDTO {
    private String firstname;
    private String secondname;
    private String addrese;
    private String gmail;
    private String photo;
    // URL ou chemin du fichier photo
    @Enumerated(EnumType.STRING)
    private String niveau; // Enum Niveau converti en String
    private Long id_classe;

    private Long idel;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
