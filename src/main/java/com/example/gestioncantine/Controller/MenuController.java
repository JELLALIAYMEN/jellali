package com.example.gestioncantine.Controller;

import com.example.gestioncantine.Service.Iservice;
import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Typemenucommandé;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    private Iservice IserviceImpl ;

    @PostMapping("/savemenu")
    public MenuDTO saveMenu(@RequestBody MenuDTO menuDTO) {
        return IserviceImpl .saveMenu(menuDTO);
    }

    @PutMapping("/menu/{id}")
    public MenuDTO updateMenu(@PathVariable Long id, @RequestParam  Typemenucommandé typemenucommandé) {
        return IserviceImpl .updateMenu(id, typemenucommandé);
    }


    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable Long id) {
        IserviceImpl .deleteMenu(id);
    }


    @GetMapping("/menus")


    public List<MenuDTO> findAll() {
        return IserviceImpl .findAll();
    }
    @GetMapping("/{idmenu}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable Long idmenu,@RequestHeader("loggedInUser") String username) {
        System.out.println("logged in user details: -  "+username);
        MenuDTO menuDTO =IserviceImpl.findByidmenu(idmenu);
        if (menuDTO != null) {
            return ResponseEntity.ok(menuDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
