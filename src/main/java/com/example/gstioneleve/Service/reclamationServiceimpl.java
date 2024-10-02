package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ReclamationDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Reclamation;
import com.example.gstioneleve.entites.ResultatRéclamation;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Reclamationep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class reclamationServiceimpl implements ReclamationSevice {
@Autowired

    Mapperdto dto;
    @Autowired
    Reclamationep reclamationep;
    @Autowired
    Eleverep eleverep;




@Override
public ReclamationDTO saveReclamation(ReclamationDTO reclamationDTO) {
    // Récupérer l'élève par son code
    Eleve eleve = eleverep.findByCode(reclamationDTO.getCode());

    if (eleve != null) {
        // Convertir le DTO en entité Reclamation
        Reclamation reclamation = dto.fromReclamationDTO(reclamationDTO);

        // Associer l'élève à la réclamation
        reclamation.setEleve(eleve);

        // Sauvegarder la réclamation dans la base de données
        Reclamation savedReclamation = reclamationep.save(reclamation);

        // Afficher le code de l'élève dans la console (facultatif)
        System.out.println("Élève trouvé : " + eleve + " avec le code : " + reclamationDTO.getCode());

        // Retourner la réclamation sauvegardée en tant que DTO
        return dto.fromReclamation(savedReclamation);
    }

    // Lancer une exception si l'élève n'est pas trouvé
    throw new RuntimeException("Élève non trouvé avec le code : " + reclamationDTO.getCode());
}

    @Override
    public ReclamationDTO updateReclamation(String resultat, Long id) {
    Reclamation reclamation=reclamationep.findById(id).orElse(null);
    reclamation.setResultatRéclamation(ResultatRéclamation.traiter);
    reclamationep.save(reclamation);
    return  dto.fromReclamation(reclamation);
    }

    @Override
    public List<ReclamationDTO> findByEleve_Code(String code) {
       List<Reclamation> reclamations=reclamationep.findByEleve_Code(code);
       return  reclamations.stream().map(reclamation -> dto.fromReclamation(reclamation)).collect(Collectors.toList());
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationep.deleteById(id);

    }

}
