package com.example.gestioncantine.Mapper;

import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.awt.*;
@Service
public class MapperDTO {

    public MenuDTO fromMenu(Menu menu) {
        if (menu == null) {
            return null; // ou lancer une exception
        }

        MenuDTO menuDTO = new MenuDTO();
        BeanUtils.copyProperties(menu, menuDTO);

        // Récupérer l'ID de l'élève
        menuDTO.setIdel(menu.getIdel());

        return menuDTO;
    }

    public Menu fromMenuDTO(MenuDTO menuDTO) {
        if (menuDTO == null) {
            return null; // ou lancer une exception
        }

        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);

        // Assurez-vous que l'ID de l'élève est correctement mappé
        menu.setIdel(menuDTO.getIdel());

        return menu;
    }

}






