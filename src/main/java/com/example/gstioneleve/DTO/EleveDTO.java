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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EleveDTO {
    private Long id;
    private String code;
    private String firstname;
    private String secondname;

    private String addrese;
    private String gmail;
    private String photo;

}