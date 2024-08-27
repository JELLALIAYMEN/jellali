package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import com.example.gstioneleve.rep.Noterep;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceimpl  implements  NoteService{
    @Autowired
    Mapperdto mapperdto;
    @Autowired
    Noterep noterep;
    @Autowired
    Eleverep eleverep;
    @Autowired
    Matiererep matiererep;
    @Override

    public NoteDTO save(NoteDTO noteDTO) {
        // Create a new Note entity
        Note note = new Note();
        note.setTypeNote(noteDTO.getTypeNote());
        note.setValeur(noteDTO.getValeur());
        note.setTrimestre(noteDTO.getTrimestre());

        // Assign the Eleve if eleveId is provided
        if (noteDTO.getEleveId() != null) {
            Eleve eleve = eleverep.findById(noteDTO.getEleveId())
                    .orElseThrow(() -> new RuntimeException("Élève non trouvé"));
            note.setEleve(eleve);
        }

        // Assign the Matiere if matiereId is provided
        if (noteDTO.getMatiereId() != null) {
            Matiere matiere = matiererep.findById(noteDTO.getMatiereId())
                    .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
            note.setMatiere(matiere);
        }

        // Save the Note entity
        Note savedNote = noterep.save(note);

        // Convert the saved Note entity to NoteDTO
        return new NoteDTO(
                savedNote.getId(),
                savedNote.getTypeNote(),
                savedNote.getValeur(),
                savedNote.getTrimestre(),
                savedNote.getEleve() != null ? savedNote.getEleve().getId() : null, // Adjust according to actual field
                savedNote.getMatiere() != null ? savedNote.getMatiere().getMatiereId() : null // Adjust according to actual field
        );
    }

    @Override
    public void update(long id, NoteDTO noteDTO) {
        // Retrieve the existing Note entity by ID
        Note note = noterep.findById(id)
                .orElseThrow(() -> new RuntimeException("Note with ID " + id + " not found"));

        // Update fields of the Note entity with values from NoteDTO
        note.setTypeNote(noteDTO.getTypeNote());
        note.setValeur(noteDTO.getValeur());
        note.setTrimestre(noteDTO.getTrimestre());

        // Assign the Eleve if eleveId is provided
        if (noteDTO.getEleveId() != null) {
            Eleve eleve = eleverep.findById(noteDTO.getEleveId())
                    .orElseThrow(() -> new RuntimeException("Élève with ID " + noteDTO.getEleveId() + " not found"));
            note.setEleve(eleve);
        } else {
            note.setEleve(null); // Optionally set to null if no ID is provided
        }

        // Assign the Matiere if matiereId is provided
        if (noteDTO.getMatiereId() != null) {
            Matiere matiere = matiererep.findById(noteDTO.getMatiereId())
                    .orElseThrow(() -> new RuntimeException("Matière with ID " + noteDTO.getMatiereId() + " not found"));
            note.setMatiere(matiere);
        } else {
            note.setMatiere(null); // Optionally set to null if no ID is provided
        }

        // Save the updated Note entity
        noterep.save(note);
    }

    @Override
    public NoteDTO findByid(long id) {
        Note  note=noterep.findById(id).orElse(null);
     noterep.save(note);
 return  mapperdto.fromNote(note);

    }

    @Override
    public List<NoteDTO> findByEleveAndTrimestre(String code, Trimestre trimestre) {
        Eleve eleve = eleverep.findByCode(code).orElse(null);
        if (trimestre == trimestre) {
            List<Note> notes = eleve.getNotes();
            return notes.stream()
                    .map(note -> mapperdto.fromNote(note))
                    .collect(Collectors.toList());

        }

    return  null;


}}