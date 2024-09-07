package com.example.pfegestiondocument.Service;

import com.example.pfegestiondocument.Exeption.TodoCollectionException;
import com.example.pfegestiondocument.Model.EleveDTO;
import com.example.pfegestiondocument.Model.TodoDTO;
import com.example.pfegestiondocument.Model.TypeTodoDTO;
import com.example.pfegestiondocument.Rep.Todorep;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceimpl implements TodoService {
    @Autowired
    Todorep todorep;

    //creation de   Expetion  personnalise:
    @Override
    public void createTodo(TodoDTO todoDTO) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todoDTOOptional = todorep.findByTodo(todoDTO.getTodo());
        if (todoDTOOptional.isPresent()) {
            throw new TodoCollectionException((TodoCollectionException.TodoAlAlreadyExists()));
        } else {
            todoDTO.setCreatedAt(new Date(System.currentTimeMillis()));
            todorep.save(todoDTO);
        }

    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<TodoDTO> todoDTOS = todorep.findAll();
        if (todoDTOS.size() > 0) {
            return todoDTOS;
        } else {
            return new ArrayList<TodoDTO>();
        }
    }

    @Override
    public TodoDTO getSingleTodo(String id) throws TodoCollectionException {
        Optional<TodoDTO> optionalTodoDTO = todorep.findById(id);
        if (!optionalTodoDTO.isPresent()) {
            throw new TodoCollectionException(TodoCollectionException.NotFoundExeption(id));
        } else {
            return optionalTodoDTO.get();
        }
    }

    @Override
    public void updateTodo(String id, TodoDTO todoDTO) throws TodoCollectionException {
        Optional<TodoDTO> todoWithId = todorep.findById(id);
        Optional<TodoDTO> todoWithSameName = todorep.findByTodo(todoDTO.getTodo());

        if (todoWithId.isPresent()) {
            if (todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id)) {
                throw new TodoCollectionException(TodoCollectionException.TodoAlAlreadyExists());
            }

            TodoDTO todoToUpdate = todoWithId.get();
            todoToUpdate.setTodo(todoDTO.getTodo());
            todoToUpdate.setDescription(todoDTO.getDescription());
            todoToUpdate.setCompleted(todoDTO.getCompleted());
            todoToUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));

            todorep.save(todoToUpdate);
        } else {
            throw new TodoCollectionException(TodoCollectionException.NotFoundExeption(id));
        }
    }

    @Override
    public void deleteTodoById(String id) throws TodoCollectionException {
        Optional<TodoDTO> todoDTOOptional = todorep.findById(id);
        if (!todoDTOOptional.isPresent()) {
            throw new TodoCollectionException(TodoCollectionException.NotFoundExeption(id));

        } else {
            todorep.deleteById(id);
        }

    }

    @Override
    public List<TodoDTO> findTodoByeleveDTO(String code) {
        EleveDTO eleveDTO=todorep.findTodoByeleveDTO(code);
        if(eleveDTO!=null){
            List<TodoDTO> todoDTOS=eleveDTO.getDocuments();

        }
    return   null;


}}






