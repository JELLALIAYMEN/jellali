package com.example.pfegestiondocument.Controller;

import com.example.pfegestiondocument.Exeption.TodoCollectionException;
import com.example.pfegestiondocument.Model.TodoDTO;

import com.example.pfegestiondocument.Rep.Todorep;
import com.example.pfegestiondocument.Service.TodoService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;


@RestController
public class TodoController {
    @Autowired
    private Todorep todorep;
    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllTodos() {
        List<TodoDTO> todoDTOS = todoService.getAllTodos();
        return new ResponseEntity<>(todoDTOS, todoDTOS.size() > 0 ? OK : NOT_FOUND);

    }


    @PostMapping("/SavetodoDTOS")
    public ResponseEntity<?> createToDTO(@RequestBody TodoDTO dto) {
        try {

            todoService.createTodo(dto);
            return new ResponseEntity<TodoDTO>(dto, OK);
        } catch (ConstraintViolationException e) {

            return new ResponseEntity<>(e.getMessage(), UNPROCESSABLE_ENTITY);
        } catch (TodoCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), CONFLICT);
        }


    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getSingleTodo(@PathVariable("id") String id) {
        try {
            TodoDTO todoDTO = todoService.getSingleTodo(id);
            if (todoDTO != null) {
                return new ResponseEntity<>(todoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/todocs/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody TodoDTO dto) {
       try {
           todoService.updateTodo(id,dto);
           return  new ResponseEntity<>("Update Todo with id"+id, OK);
       } catch (ConstraintViolationException e) {
return  new ResponseEntity<>(e.getMessage(), UNPROCESSABLE_ENTITY);
       } catch (TodoCollectionException e){
           return  new ResponseEntity<>(e.getMessage(), NOT_FOUND);
       }
    }

    @DeleteMapping("/todosde/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
        try {

            todoService.deleteTodoById(id);
            return new ResponseEntity<>("Successfully deleted with id " + id, OK);
        } catch (TodoCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
        }
    }
}
