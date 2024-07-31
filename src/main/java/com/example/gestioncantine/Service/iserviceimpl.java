package com.example.gestioncantine.Service;

import com.example.gestioncantine.Mapper.MapperDTO;
import com.example.gestioncantine.Rep.Eleverep;
import com.example.gestioncantine.Rep.Menurep;
import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Eleve;
import com.example.gestioncantine.entites.Menu;
import com.example.gestioncantine.entites.Typemenucommandé;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class iserviceimpl implements Iservice {
    @Autowired
    MapperDTO mapperDTO;
    @Autowired
    Menurep menurep;
    @Autowired
    Eleverep eleverep;

    @Override
    public MenuDTO saveMenu(MenuDTO menuDTO) {
        try {
            Menu menu = mapperDTO.fromMenuDTO(menuDTO);
            Menu savedMenu = menurep.save(menu);
            return mapperDTO.fromMenu(savedMenu);
        } catch (DataAccessException ex) {
            // Gérer l'exception (ex : logger, rethrow, etc.)
            throw new RuntimeException("Erreur lors de l'enregistrement du menu", ex);
        }

    }

    @Override
    public MenuDTO updateMenu(Long idmenu, Typemenucommandé typemenucommandé) {
        Menu menu=menurep.findById(idmenu).orElse(null);
        menu.setTypemenucommandé(typemenucommandé);
        menurep.save(menu);
        return  mapperDTO.fromMenu(menu);


    }

    @Override
    public MenuDTO findMenuByEleve(String code) {
       Eleve eleve=eleverep.findByCode(code);
       if (eleve!=null){
       Menu menu=    eleve.getMenu();
       menurep.save(menu);
       return  mapperDTO.fromMenu(menu);
       }
       return  null;
    }

    @Override
    public void deleteMenu(Long idmenu) {
        menurep.deleteById(idmenu);
            }

    @Override
    public List<MenuDTO> findAll() {
       List<Menu> menus=menurep.findAll();
       return  menus.stream().map(menu -> mapperDTO.fromMenu(menu)).collect(Collectors.toList());
    }


}