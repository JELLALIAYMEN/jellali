package com.example.pfegestiondocument.Model;



import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import javax.validation.constraints.NotNull;


import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Doc")
public class TodoDTO {
    @Id
    private String id;

    @NotNull(message = "todoDTO cannot be null")
    private String todo;

 @NotNull(message = "description cannot be null")
    private String description;

    @NotNull(message = "completed cannot be null")
    private String completed;

    private  TypeTodoDTO typeTodoDTO;
    private Long idel;




    private Date createdAt;
    private Date updatedAt;
}

