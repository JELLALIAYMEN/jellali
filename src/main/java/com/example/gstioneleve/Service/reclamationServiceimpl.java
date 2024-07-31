package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ReclamationDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Reclamation;
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

    @Override
    public ReclamationDTO savereclamation(ReclamationDTO reclamationDTO) {
        Reclamation reclamation=dto.fromReclamationDTO(reclamationDTO);
           Reclamation savedrec=reclamationep.save(reclamation);


            return  dto.fromReclamation(savedrec);
    }

    @Override
    public ReclamationDTO updateReclamation(String resultat, Long id) {
    Reclamation reclamation=reclamationep.findById(id).orElse(null);
    reclamation.setResultat(resultat);
    reclamationep.save(reclamation);
    return  dto.fromReclamation(reclamation);
    }

    @Override
    public List<ReclamationDTO> findByCode(String code) {
       List<Reclamation> reclamations=reclamationep.findByCode(code);
       return  reclamations.stream().map(reclamation -> dto.fromReclamation(reclamation)).collect(Collectors.toList());
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationep.deleteById(id);

    }

}
