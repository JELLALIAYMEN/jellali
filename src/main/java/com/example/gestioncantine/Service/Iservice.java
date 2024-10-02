package com.example.gestioncantine.Service;

import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Typemenucommandé;

import java.util.List;

public interface Iservice {
    MenuDTO saveMenu(MenuDTO menuDTO);


    public MenuDTO updateMenu( Long idmenu,  Typemenucommandé typemenucommandé);


MenuDTO findByidmenu(Long idmenu);
  void deleteMenu(Long idmenu);
  List<MenuDTO> findAll();

}
