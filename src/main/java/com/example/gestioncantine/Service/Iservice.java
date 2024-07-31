package com.example.gestioncantine.Service;

import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Typemenucommandé;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Iservice {
    MenuDTO saveMenu(MenuDTO menuDTO);


    public MenuDTO updateMenu( Long idmenu,  Typemenucommandé typemenucommandé);


    MenuDTO findMenuByEleve(String code);
  void deleteMenu(Long idmenu);
  List<MenuDTO> findAll();
}
