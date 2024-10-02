package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Classerep;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import com.example.gstioneleve.rep.Noterep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InoteServiceimpl implements  Inoteservice {
    @Autowired
    Noterep noterep;

    @Autowired
    Eleverep eleverep;
    @Autowired
    Matiererep matiererep;
    @Autowired
    Mapperdto mapperdto;

    @Autowired
    Classerep classerep;
    @Autowired
    Matisrvi Matsrvicimpl;
    @Override
    public List<NoteDTO> findByEleve_IdelAndid_matiereAndTrimestre(Long idel, Long id_matiere, Trimestre trimestre) {
        // Chercher l'élève et la matière par leurs ID
        Eleve eleve = eleverep.findById(idel).orElse(null);
        Matiere matiere = matiererep.findById(id_matiere).orElse(null);

        // Vérifier si l'élève ou la matière sont absents
        if (eleve == null || matiere == null) {
            // Si l'élève ou la matière n'existe pas, retourner une liste vide
            return Collections.emptyList();
        }

        // Filtrer les notes pour obtenir celles correspondant à la matière et au trimestre
        List<Note> notes = eleve.getNotes().stream()
                .filter(note -> note.getMatiere().equals(matiere) && trimestre.equals(note.getTrimestre()))
                .collect(Collectors.toList());

        // Convertir les notes en DTO
        return notes.stream()
                .map(mapperdto::fromNote)
                .collect(Collectors.toList());
    }



//    @Override
//    public List<NoteDTO> findByElllAndAndMatiere(Long idel, Long idmatiere) {
//        Eleve eleve=eleverep.findById(idel).orElse(null);
//
//        Matiere m=matiererep.findById(idmatiere).orElse(null);
//        List<Note> notes=noterep.findByElllAndAndMatiere(eleve,m);
//        return  notes.stream().map(note ->noteMapper.toNoteDTO(note)).collect(Collectors.toList());
//
//
//
//    }


    @Override
    public NoteDTO save(NoteDTO noteDTO) {
       Note note=mapperdto.fromNoteDTO(noteDTO);
       Note saveen=noterep.save(note);
        return  mapperdto.fromNote(saveen);






    }




   }








