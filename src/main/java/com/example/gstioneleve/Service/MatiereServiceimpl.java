package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Actualite;
import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.Matiere;
import com.example.gstioneleve.rep.Matiererep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatiereServiceimpl implements MatiereService{
    @Autowired
    Mapperdto mapperdto;
    @Autowired
    Matiererep  matiererep;
    @Override
    public MatiereDTO saveMatiere(MatiereDTO matiereDTO) {
        // Convertir le DTO en entité
        Matiere matiere = new Matiere();
        matiere.setMatiereId(matiereDTO.getMatiereId());
        matiere.setNom(matiereDTO.getNom());
        matiere.setCoefficient(matiereDTO.getCoffécient()); // Assurez-vous que le nom de la méthode est correct
        matiere.setOption(matiereDTO.getOption());

        // Save entity to repository
        Matiere savedMatiere = matiererep.save(matiere); // Correction de 'matiererep' à 'matiereRep'

        // Convert saved entity back to DTO
        MatiereDTO savedMatiereDTO = new MatiereDTO();
        savedMatiereDTO.setMatiereId(savedMatiere.getMatiereId()); // Correction de 'm' à 'savedMatiere'
        savedMatiereDTO.setNom(savedMatiere.getNom());
        savedMatiereDTO.setCoffécient(savedMatiere.getCoefficient()); // Assurez-vous que le nom de la méthode est correct
        savedMatiereDTO.setOption(savedMatiere.getOption());

        return savedMatiereDTO;
    }


}
