package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ClasseDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Actualite;
import com.example.gstioneleve.entites.Classe;
import com.example.gstioneleve.rep.Classerep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasseSeimpl implements  Classeser{
    @Autowired
    Classerep classerep;
    @Autowired
    Mapperdto mapperdto;
    @Override
    public ClasseDTO saveClasse(ClasseDTO classeDTO) {
        // Convertir le DTO en entité
        Classe classe = mapperdto.fromDTO(classeDTO);

        // Enregistrer l'entité dans le repository
        Classe savedClasse = classerep.save(classe);

        // Convertir l'entité enregistrée en DTO et le retourner
        return mapperdto.toDTO(savedClasse);
    }


}
