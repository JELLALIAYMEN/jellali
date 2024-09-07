package com.example.pfegestiondocument.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation="Docdto")
public class EleveDTO {
    @Id
   private  Long id;

   private  String code;
   private  String nom;
   private  String  prenom;
   private  String  gmail;

@DBRef
    private List<TodoDTO> Documents;
}
