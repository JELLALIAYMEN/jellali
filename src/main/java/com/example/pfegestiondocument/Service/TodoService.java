package com.example.pfegestiondocument.Service;

import com.example.pfegestiondocument.Exeption.TodoCollectionException;
import com.example.pfegestiondocument.Model.TodoDTO;
import com.example.pfegestiondocument.Model.TypeTodoDTO;
import jakarta.validation.ConstraintViolationException;


import java.util.List;
import java.util.Optional;

public interface TodoService {
   public void createTodo(TodoDTO todoDTO) throws ConstraintViolationException, TodoCollectionException;
   public List<TodoDTO>  getAllTodos();
   public  TodoDTO getSingleTodo(String id ) throws  TodoCollectionException;
   public  void updateTodo(String id,TodoDTO todoDTO) throws  TodoCollectionException;
   public  void deleteTodoById(String id) throws TodoCollectionException;
public  List<TodoDTO> findTodoByeleveDTO(String code);



}
