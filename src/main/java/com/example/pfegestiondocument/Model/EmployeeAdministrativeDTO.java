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
public class EmployeeAdministrativeDTO {
    private Long id;
    private  String firstname;
    private  String Lastname;
    private  String email;
    @DBRef
    private List<TodoDTO> Documents;

}
