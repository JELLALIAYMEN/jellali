package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Moyenne;
import com.example.gstioneleve.entites.Periode;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.MoyenneRep;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoyenneServiceimpl implements Moyenneservice {

    @Autowired
    private MoyenneRep moyenneRep;

    @Autowired
    private Mapperdto dto;

    @Autowired
    private Eleverep eleverep;
    @Override
    public MoyenneDTO saveMoyenne(MoyenneDTO moyenneDTO) {
        Moyenne moyenne = dto.fromMoyenDTO(moyenneDTO);
        Moyenne savedMoyenne = moyenneRep.save(moyenne);
        return dto.fromMoyennDTO(savedMoyenne);
    }

    @Override
    public MoyenneDTO updateMoyenne(Double moyennevalue, Long idmoy) {
        Moyenne moyenne = moyenneRep.findById(idmoy).orElse(null);
        if (moyenne != null) {
            moyenne.setMoyennevalue(moyennevalue);
            Moyenne updatedMoyenne = moyenneRep.save(moyenne);
            return dto.fromMoyennDTO(updatedMoyenne);
        }
        return null;
    }

//    @Override
//    public MoyenneDTO findByPeriodeAndCode(Periode periode, String code) {
//        Eleve eleve = eleverep.findByCode(code);
//        if (eleve != null) {
//            List<Moyenne> moyennes = eleve.getMoyennes();
//            List<Moyenne> filteredMoyennes = moyennes.stream()
//                    .filter(moyenne -> moyenne.getPeriode().equals(periode))
//                    .collect(Collectors.toList());
//            return filteredMoyennes.stream()
//                    .map(dto::fromMoyenne)
//                    .collect(Collectors.toList());
//        } else {
//            throw new EntityNotFoundException("Eleve not found with code " + code);
//        }
//    }

    @Override
    public void deleteMoyenne(Long idMoyenne) {
        moyenneRep.deleteById(idMoyenne);
    }

    @Override
    public List<MoyenneDTO> findAll() {
        List<Moyenne> moyennes = moyenneRep.findAll();
        return moyennes.stream().map(moyenne -> dto.fromMoyennDTO(moyenne)).collect(Collectors.toList());

    }
}