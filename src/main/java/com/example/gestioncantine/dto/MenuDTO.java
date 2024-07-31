package com.example.gestioncantine.dto;

import com.example.gestioncantine.entites.Typemenucommandé;
import lombok.Data;

@Data
public class MenuDTO {
    private  Long idmenu;
    private  String nomplatprincipal;
    private  String  nomplatDessert;

    private String nomplatentré;
    private Typemenucommandé typemenucommandé;
    private  String code;

}
