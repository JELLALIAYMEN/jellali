package com.example.gestioncantine.Mapper;

import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class MapperDTO {
    public MenuDTO fromMenu(Menu menu){
      MenuDTO menuDTO=new MenuDTO();
        BeanUtils.copyProperties(menu,menuDTO);
        return  menuDTO;
    }
    public Menu fromMenuDTO(MenuDTO menuDTO){
        Menu menu=new Menu();
        BeanUtils.copyProperties(menuDTO,menu);
        return  menu;
    }


}
