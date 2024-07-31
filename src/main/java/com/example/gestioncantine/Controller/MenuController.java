package com.example.gestioncantine.Controller;

import com.example.gestioncantine.Service.Iservice;
import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Typemenucommandé;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
public class MenuController {

    @Autowired
    private Iservice iserviceimpl;

    @PostMapping("/savemenu")
    public MenuDTO saveMenu(@RequestBody MenuDTO menuDTO) {
        return iserviceimpl.saveMenu(menuDTO);
    }

    @PutMapping("/menu/{id}")
    public MenuDTO updateMenu(@PathVariable Long id, @RequestBody Typemenucommandé typemenucommandé) {
        return iserviceimpl.updateMenu(id, typemenucommandé);
    }

    @GetMapping("/menu/{code}")
    public MenuDTO findMenuByEleve(@PathVariable String code) {
        return iserviceimpl.findMenuByEleve(code);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable Long id) {
        iserviceimpl.deleteMenu(id);
    }

    @GetMapping("/menus")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MenuDTO> findAll() {
        return iserviceimpl.findAll();
    }
}
