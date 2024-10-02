package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.ActualiteDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Actualite;
import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.rep.Actualiterep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActualiteServiceimpl  implements  ActualiteService{
    @Autowired
    Mapperdto dto;
    @Autowired
    DisciplineService disciplineServiceimpl;
    @Autowired
    Actualiterep actualiterep;

    @Override
    public ActualiteDTO saveActualite(ActualiteDTO actualiteDTO) {
        Actualite actualite=dto.fromActualiteDTO(actualiteDTO);
       Actualite savedac=actualiterep.save(actualite);



        return  dto.fromActualite(savedac);
    }

    @Override
    public List<ActualiteDTO> findAllActualite() {
    List<Actualite> actualites=actualiterep.findAll();

    return  actualites.stream().map(actualite -> dto.fromActualite(actualite)).collect(Collectors.toList());
    }

    @Override
    public void deleteActualiteById(Long id) {
      actualiterep.deleteById(id);
    }
}
