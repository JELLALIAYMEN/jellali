package com.example.gstioneleve.Mapper;

import com.example.gstioneleve.DTO.*;
import com.example.gstioneleve.entites.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Mapperdto {

    public  NoteDTO fromNote(Note note){
        if(note==null){
            return  null;
        }
        NoteDTO noteDTO=new NoteDTO();
        BeanUtils.copyProperties(note, noteDTO);

        // Gestion des propriétés spéciales, par exemple les collections
        // eleveDTO.setPayements(eleve.getPayements().stream().map(this::fromPayement).collect(Collectors.toList()));

        return noteDTO;
    }

    public Note fromNoteDTO(NoteDTO noteDTO) {
        if (noteDTO == null) {
            return null;
        }

        Note note = new Note();
        BeanUtils.copyProperties(noteDTO, note);

        // Ajouter les conversions pour les relations d'entité
        // Vous devrez peut-être récupérer les objets `Eleve` et `Matiere` de la base de données si nécessaire
        // note.setEleve(new Eleve(noteDTO.getEleveId()));
        // note.setMatiere(new Matiere(noteDTO.getMatiereId()));

        return note;
    }

    public EleveDTO fromEleve(Eleve eleve) {
        if (eleve == null) {
            return null;
        }

        EleveDTO eleveDTO = new EleveDTO();
        BeanUtils.copyProperties(eleve, eleveDTO);

        // Gestion des propriétés spéciales, par exemple les collections
        // eleveDTO.setPayements(eleve.getPayements().stream().map(this::fromPayement).collect(Collectors.toList()));

        return eleveDTO;
    }

    public Eleve fromEleveDTO(EleveDTO eleveDTO) {
        if (eleveDTO == null) {
            return null;
        }

        Eleve eleve = new Eleve();
        BeanUtils.copyProperties(eleveDTO, eleve);

        // Gestion des propriétés spéciales, par exemple les collections
        // eleve.setPayements(eleveDTO.getPayements().stream().map(this::fromPayementDTO).collect(Collectors.toList()));

        return eleve;
    }

    public DisciplineDTO fromDiscipline(Discipline discipline) {
        if (discipline == null) {
            return null;
        }

        DisciplineDTO dto = new DisciplineDTO();
        BeanUtils.copyProperties(discipline, dto);
        return dto;
    }

    public Discipline fromDisciplineDTO(DisciplineDTO disciplineDTO) {
        if (disciplineDTO == null) {
            return null;
        }

        Discipline discipline = new Discipline();
        BeanUtils.copyProperties(disciplineDTO, discipline);
        return discipline;
    }

    public ReclamationDTO fromReclamation(Reclamation reclamation) {
        if (reclamation == null) {
            return null;
        }

        ReclamationDTO reclamationDTO = new ReclamationDTO();
        BeanUtils.copyProperties(reclamation, reclamationDTO);
        return reclamationDTO;
    }

    public Reclamation fromReclamationDTO(ReclamationDTO reclamationDTO) {
        if (reclamationDTO == null) {
            return null;
        }

        Reclamation reclamation = new Reclamation();
        BeanUtils.copyProperties(reclamationDTO, reclamation);
        return reclamation;
    }


    public ActualiteDTO fromActualite(Actualite actualite) {
        if (actualite == null) {
            return null;
        }

        ActualiteDTO actualiteDTO = new ActualiteDTO();
        BeanUtils.copyProperties(actualite, actualiteDTO);
        return actualiteDTO;
    }

    public Actualite fromActualiteDTO(ActualiteDTO actualiteDTO) {
        if (actualiteDTO == null) {
            return null;
        }

        Actualite actualite = new Actualite();
        BeanUtils.copyProperties(actualiteDTO, actualite);
        return actualite;
    }

    public MatiereDTO fromMatiere(Matiere matiere) {
        if (matiere == null) {
            return null;
        }

        MatiereDTO matiereDTO = new MatiereDTO();
        BeanUtils.copyProperties(matiere, matiereDTO);
        return matiereDTO;
    }

    public Matiere fromMatiereDTO(MatiereDTO matiereDTO) {
        if (matiereDTO == null) {
            return null;
        }

        Matiere matiere = new Matiere();
        BeanUtils.copyProperties(matiereDTO, matiere);
        return matiere;
    }

    public Payement fromPayementDTO(PayementDTO payementDTO) {
        if (payementDTO == null) {
            return null;
        }

        Payement payement = new Payement();
        BeanUtils.copyProperties(payementDTO, payement);
        return payement;
    }

    public PayementDTO fromPayement(Payement payement) {
        if (payement == null) {
            return null;
        }

        PayementDTO payementDTO = new PayementDTO();
        BeanUtils.copyProperties(payement, payementDTO);
        return payementDTO;
    }
    public  MoyenneDTO fromMoyennDTO(Moyenne moyenne){
        MoyenneDTO moyenneDTO=new MoyenneDTO();
        BeanUtils.copyProperties(moyenne, moyenneDTO);
        return moyenneDTO;
    }
    public Moyenne fromMoyenDTO(MoyenneDTO moyenneDTO){
        Moyenne moyenne=new Moyenne();
        BeanUtils.copyProperties(moyenneDTO,moyenne);
        return moyenne;
    }
}

