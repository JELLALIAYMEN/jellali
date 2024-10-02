package com.example.gestioncantine.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.gestioncantine.Mapper.MapperDTO;
import com.example.gestioncantine.Rep.Menurep;
import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Menu;
import com.example.gestioncantine.entites.Typemenucommandé;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IserviceImpl implements Iservice {
    @Autowired
    MapperDTO mapperDTO;
    @Autowired
    Menurep menurep;
    @Override
    public MenuDTO saveMenu(MenuDTO menuDTO) {
        // Convertir le MenuDTO en Menu
        Menu menu = mapperDTO.fromMenuDTO(menuDTO); // Assurez-vous que `mapper` est injecté

        // Vérifier si l'ID de l'élève est présent dans le DTO
        if (menuDTO.getIdel() == null) {
            throw new RuntimeException("L'ID de l'élève doit être fourni.");
        }

        // Sauvegarder le menu en base de données
       menurep.save(menu); // Assurez-vous que `menuRepository` est injecté

        // Retourner le MenuDTO avec les informations sauvegardées
        return mapperDTO.fromMenu(menu); // Convertir à nouveau en MenuDTO si nécessaire
    }






    @Override
    public MenuDTO updateMenu(Long idmenu, Typemenucommandé typemenucommandé) {
        Menu menu = menurep.findById(idmenu).orElse(null);
        menu.setTypemenucommandé(typemenucommandé);
        menurep.save(menu);
        return mapperDTO.fromMenu(menu);
    }

    @Override
    public MenuDTO findByidmenu(Long idmenu) {
      Menu menu=menurep.findById(idmenu).orElse(null);
      return  mapperDTO.fromMenu(menu);

    }

    @Override
    public void deleteMenu(Long idmenu) {
        menurep.deleteById(idmenu);
    }

    @Override
    public List<MenuDTO> findAll() {
        List<Menu> menus = menurep.findAll();
        return menus.stream()
                .map(menu -> {
                    // Log ici pour vérifier l'état de chaque menu
                    System.out.println("Menu: " + menu + ", Eleve: " + menu.getIdel());
                    return this.mapperDTO.fromMenu(menu); // Appel à la méthode fromMenu
                })
                .collect(Collectors.toList());
    }



}