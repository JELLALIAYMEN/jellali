package com.example.gstioneleve.Mapper;

import com.example.gstioneleve.DTO.*;
import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapperdto {

    @Autowired
    private  Eleverep eleverep;
    @Autowired
    private Matiererep matiererep;
    public NoteDTO fromNote(Note note) {
        if (note == null) {
            return null;
        }

        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId()); // Assurez-vous que la méthode correspond
        noteDTO.setTypeNote(note.getTypeNote()); // Assurez-vous que la méthode correspond
        noteDTO.setValeur(note.getValeur()); // Assurez-vous que la méthode correspond
        noteDTO.setTrimestre(note.getTrimestre()); // Assurez-vous que la méthode correspond

        // Mappage des IDs
        noteDTO.setEleveId(note.getEleve() != null ? note.getEleve().getId() : null); // Mappage de l'identifiant de l'élève
        noteDTO.setMatiereId(note.getMatiere() != null ? note.getMatiere().getMatiereId() : null); // Mappage de l'identifiant de la matière

        return noteDTO;
    }

    // Convertir NoteDTO en Note
    public Note fromNoteDTO(NoteDTO noteDTO) {
        if (noteDTO == null) {
            return null;
        }

        Note note = new Note();
        note.setId(noteDTO.getId()); // Assurez-vous que la méthode correspond
        note.setTypeNote(noteDTO.getTypeNote()); // Assurez-vous que la méthode correspond
        note.setValeur(noteDTO.getValeur()); // Assurez-vous que la méthode correspond
        note.setTrimestre(noteDTO.getTrimestre()); // Assurez-vous que la méthode correspond

        // Mappage des entités pour les IDs
        // Ici, vous devrez récupérer les entités Eleve et Matiere à partir de leurs IDs
        // Assurez-vous d'injecter les repositories ou services nécessaires

        Eleve eleve = eleverep.findById(noteDTO.getEleveId()).orElse(null); // Vous devez injecter eleveRepository
        Matiere matiere = matiererep.findById(noteDTO.getMatiereId()).orElse(null); // Vous devez injecter matiereRepository

        note.setEleve(eleve); // Assignez l'entité Eleve
        note.setMatiere(matiere); // Assignez l'entité Matiere

        return note;
    }



    public EleveDTO fromEleve(Eleve eleve) {
        if (eleve == null) {
            return null;
        }
       EleveDTO eleveDTO=new EleveDTO();
        BeanUtils.copyProperties(eleve, eleveDTO);
        return eleveDTO;

    }




    public Eleve fromEleveDTO(EleveDTO eleveDTO) {
            if (eleveDTO == null) {
                return null;
            }

            Eleve eleve = new Eleve(); // Correction: instantiation correcte de l'objet Eleve
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



    public Payement fromPayementDTO(PayementDTO payementDTO) {
        if (payementDTO == null) {
            return null;
        }

        Payement payement = new Payement();
        BeanUtils.copyProperties(payementDTO, payement);
        return payement;
    }

    public PayementDTO fromPayement(Payement payement) {
        PayementDTO payementDTO=new PayementDTO();
       // MoyenneDTO moyenneDTO=new MoyenneDTO();
        BeanUtils.copyProperties(payement, payementDTO);
        return payementDTO;
    }



    public CoursDTO fromCours(Cours cours) {
        if (cours == null) {
            return null;
        }

        // Create a new CoursDTO and copy properties from the Cours entity
        CoursDTO coursDTO = new CoursDTO();
        BeanUtils.copyProperties(cours, coursDTO);

        return coursDTO;
    }

    public Cours fromCoursDTO(CoursDTO coursDTO) {
        if (coursDTO == null) {
            return null;
        }

        // Create a new Cours entity and copy properties from the CoursDTO
        Cours cours = new Cours();
        BeanUtils.copyProperties(coursDTO, cours);
        return cours;
    }


    public MoyenneDTO fromMoyenne(Moyenne moyenne) {
        if (moyenne == null) {
            return null;
        }

        MoyenneDTO moyenneDTO=new MoyenneDTO();
        BeanUtils.copyProperties(moyenne, moyenneDTO);


        return moyenneDTO;
    }
    public Moyenne fromMoyenne(MoyenneDTO moyenneDTO) {
        if (moyenneDTO == null) {
            return null;
        }

        Moyenne moyenne=new Moyenne();
        BeanUtils.copyProperties(moyenneDTO, moyenne);
        return moyenne;
    }

    public MatiereDTO fromMatiere(Matiere matiere) {
        if (matiere == null) {
            return null;
        }

      MatiereDTO matiereDTO=new MatiereDTO();
        BeanUtils.copyProperties(matiere, matiereDTO);


        return matiereDTO;
    }
    public Matiere fromMatiereDTO(MatiereDTO matiereDTO) {
        if (matiereDTO == null) {
            return null;
        }

        Matiere matiere=new Matiere();
        BeanUtils.copyProperties(matiere, matiereDTO);


        return matiere;
    }

}

