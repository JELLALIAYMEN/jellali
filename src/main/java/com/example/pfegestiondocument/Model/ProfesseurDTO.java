package com.example.pfegestiondocument.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Doc")
public class ProfesseurDTO {
    private  Long id;
    private  String nom;
    private  String prenon;
    private  String gmail;
    @DBRef
    private List<TodoDTO> Documents;
}
