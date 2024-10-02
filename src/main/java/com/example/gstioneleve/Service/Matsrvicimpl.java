package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Classe;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.rep.Classerep;
import com.example.gstioneleve.rep.Matiererep;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Matsrvicimpl implements  Matisrvi {
    @Autowired
    Matiererep matiererep;
    @Autowired
    Mapperdto mapperdto;
    @Autowired
    Classerep classerep;

    @Override
    public Optional<Matiere> findById(Long idmatiere) {
        return matiererep.findById(idmatiere);

    }

    @Override
    public MatiereDTO saveMatiere(MatiereDTO matiereDTO, Long id_classe) {
        // Fetch the associated Classe
        Classe classe = classerep.findById(id_classe)
                .orElseThrow(() -> new EntityNotFoundException("Classe not found with id " + id_classe));

        // Convert DTO to entity
        Matiere matiere = new Matiere();
        matiere.setNom(matiereDTO.getNom());
        matiere.setCoff(matiereDTO.getCoff());

        // Set the related Classe entity
        matiere.setClasse(classe);

        // Save the Matiere entity
        Matiere savedMatiere = matiererep.save(matiere);

        // Convert back to DTO and return
        return mapperdto.fromMatiere(savedMatiere);
    }

}

