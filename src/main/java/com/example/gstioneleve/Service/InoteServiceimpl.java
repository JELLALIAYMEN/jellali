package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Exp.MissingExamControl2Exception;
import com.example.gstioneleve.Exp.NoteNotFoundException;
import com.example.gstioneleve.Exp.ResourceNotFoundException;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import com.example.gstioneleve.rep.Noterep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        // Trouver l'élève par code
        Eleve eleve = eleverep.findByCode(noteDTO.getCode());
        if (eleve == null) {
            throw new ResourceNotFoundException("Eleve not found with code " + noteDTO.getCode());
        }

        // Créer une nouvelle note
        Note note = new Note();
        note.setNoteControleContinue(noteDTO.getNoteControleContinue());
        note.setNoteeexamenSynthése(noteDTO.getNoteeexamenSynthése());
        note.setNoteexamencontrole1(noteDTO.getNoteexamencontrole1());
        note.setNoteexamencontrole2(noteDTO.getNoteexamencontrole2());
        note.setElll(eleve);
        note.setPeriode(noteDTO.getPeriode());

        // Sauvegarder la nouvelle note
        Note savedNote = noterep.save(note);

        // Convertir la note sauvegardée en DTO et la retourner
        return mapperdto.fromNote(savedNote);
    }

    @Override
    public NoteDTO updateNote(Long idnote, NoteDTO noteDTO) {
        // Trouver la note par ID
        Note note = noterep.findById(idnote)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + idnote));

        // Trouver l'élève par code
        Eleve eleve = eleverep.findByCode(noteDTO.getCode());
        if (eleve == null) {
            throw new ResourceNotFoundException("Eleve not found with code " + noteDTO.getCode());
        }

        // Mettre à jour les attributs de la note
        note.setNoteControleContinue(noteDTO.getNoteControleContinue());
        note.setNoteeexamenSynthése(noteDTO.getNoteeexamenSynthése());
        note.setNoteexamencontrole1(noteDTO.getNoteexamencontrole1());
        note.setNoteexamencontrole2(noteDTO.getNoteexamencontrole2());
        note.setElll(eleve);
        note.setPeriode(noteDTO.getPeriode());

        // Sauvegarder la note mise à jour
        Note updatedNote = noterep.save(note);

        // Convertir la note mise à jour en DTO et la retourner
        return mapperdto.fromNote(updatedNote);
    }





    @Override
    public MatiereDTO saveMatiere(MatiereDTO matiereDTO) {
        Matiere matiere = mapperdto.fromMatiereDTO(matiereDTO);
        Matiere savedm = matiererep.save(matiere);
        return mapperdto.fromMatiere(savedm);

    }

//    @Override
//    public List<NoteDTO> findByCodeAndMatiereAndPeriode(String code, Matiere matiere, Periode periode) {
//
//        List<Note> notes = noterep.findByCodeAndMatiereAndPeriode(code, matiere, periode);
//
//        // Convert entities to DTOs
//        return notes.stream()
//                .map(note -> mapperdto.fromNote(note))
//                .collect(Collectors.toList());
//    }

}
