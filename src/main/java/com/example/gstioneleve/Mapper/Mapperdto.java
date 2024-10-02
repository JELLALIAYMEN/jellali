package com.example.gstioneleve.Mapper;

import com.example.gstioneleve.DTO.*;
import com.example.gstioneleve.Service.InoteServiceimpl;
import com.example.gstioneleve.Service.Iservice;
import com.example.gstioneleve.Service.Matisrvi;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Classerep;
import com.example.gstioneleve.rep.Noterep;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mapperdto {
    @Autowired

    Iservice iserviceimpl;
    @Autowired
    Matisrvi Matsrvicimpl;

    @Autowired
    Classerep classerep;
    @Autowired
    private com.example.gstioneleve.Service.Matsrvicimpl matsrvicimpl;
    @Autowired
    private Noterep noterep;
    @Autowired
    private InoteServiceimpl inoteServiceimpl;

    public Eleve fromEleveDTO(EleveDTO eleveDTO) {
        if (eleveDTO == null) {
            return null;
        }

        Eleve eleve = new Eleve();
        eleve.setIdel(eleveDTO.getIdel());
        eleve.setFirstname(eleveDTO.getFirstname());
        eleve.setSecondname(eleveDTO.getSecondname());
        eleve.setAddrese(eleveDTO.getAddrese());
        eleve.setGmail(eleveDTO.getGmail());
        eleve.setPhoto(eleveDTO.getPhoto());
        if (eleve.getCode() == null )
        {
            eleve.setCode( eleve.generateCode() );
        }
        else {
            eleve.setCode(eleve.getCode());
        }

        // Convertir le niveau de String à Enum
        try {
            eleve.setNiveau(Niveau.valueOf(eleveDTO.getNiveau()));
        } catch (IllegalArgumentException e) {
            // Gérer l'erreur ou définir une valeur par défaut
            eleve.setNiveau(Niveau.SEPT); // Assurez-vous que DEFAULT est défini dans votre enum
        }

        // Assigner la classe si elle est disponible
        if (eleveDTO.getId_classe() != null) {
            Classe classe = classerep.findById(eleveDTO.getId_classe())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid class ID: " + eleveDTO.getId_classe()));
            eleve.setClasse(classe);
        }

        return eleve;
    }


    public ClasseDTO toDTO(Classe classe) {
        if (classe == null) {
            return null;
        }

        ClasseDTO dto = new ClasseDTO();
        dto.setId_classe(classe.getId_classe());
        dto.setNon(classe.getNom());

        // Si vous souhaitez inclure les Matières ou Élèves, vous pouvez décommenter ces lignes
        // dto.setMatieres(classe.getMatieres());
        // dto.setEleves(classe.getEleves());

        return dto;

    }
    public Classe fromDTO(ClasseDTO dto) {
        if (dto == null) {
            return null;
        }

        Classe classe = new Classe();
        classe.setId_classe(dto.getId_classe());
        classe.setNom(dto.getNon());

        // Si vous souhaitez gérer les Matières ou Élèves, vous pouvez décommenter ces lignes
        // classe.setMatieres(dto.getMatieres());
        // classe.setEleves(dto.getEleves());

        return classe;
    }



    public Note fromNoteDTO(NoteDTO noteDTO) {
        if (noteDTO == null) {
            return null;
        }

        Note note = new Note();
        BeanUtils.copyProperties(noteDTO, note);

        // Récupérer l'élève en utilisant l'ID
        Eleve eleve = iserviceimpl.findById(noteDTO.getIdel());

        // Récupérer la matière en utilisant l'ID et vérifier si elle est présente
        Matiere matiere = Matsrvicimpl.findById(noteDTO.getId_matiere())
                .orElseThrow(() -> new RuntimeException("Matiere not found"));

        // Assigner l'élève et la matière à la note
        note.setEleve(eleve);
        note.setMatiere(matiere); // Corriger l'affectation avec l'objet `Matiere` et non l'ID

        return note;
    }

    public NoteDTO fromNote(Note note) {
        if (note == null) {
            return null;
        }
        NoteDTO noteDTO = new NoteDTO();
        BeanUtils.copyProperties(note, noteDTO);
        noteDTO.setIdel(note.getEleve() != null ? note.getEleve().getIdel() : null);
        noteDTO.setId_matiere(note.getMatiere() != null ? note.getMatiere().getId() : null);
        return noteDTO;
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
        ReclamationDTO dto = new ReclamationDTO();
        dto.setId(reclamation.getId());
        dto.setSujet(reclamation.getSujet());
        dto.setDate(reclamation.getDate());
        dto.setResultatRéclamation(reclamation.getResultatRéclamation());

        // Ajouter le code de l'élève
        if (reclamation.getEleve() != null) {
            dto.setCode(reclamation.getEleve().getCode());
        }

        return dto;
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

    public PayementDTO fromPayement(Payement payement) {
        PayementDTO dto = new PayementDTO();
        dto.setId(payement.getId());
        dto.setAmount(payement.getAmount());
        dto.setDate(payement.getDate());
        dto.setModepay(payement.getModepay());
        dto.setFile(payement.getFile());
        dto.setTypepay(payement.getTypepay());
        dto.setStatusPay(payement.getStatuspay());

        // Check if the payment is linked to an Eleve and set the code
        if (payement.getEleve() != null) {
            dto.setCode(payement.getEleve().getCode());  // Get the code from Eleve
        }

        return dto;
    }




    public Payement fromPayementDTO(PayementDTO payementDTO) {
        if (payementDTO == null) {
            return null;
        }

        Payement payement = new Payement();
        BeanUtils.copyProperties(payementDTO, payement);
        return payement;
    }


    public MoyenneDTO fromMoyenne(Moyenne moyenne) {
        MoyenneDTO moyenneDTO = new MoyenneDTO();
        BeanUtils.copyProperties(moyenne, moyenneDTO);
        return moyenneDTO;
    }
    public Moyenne fromMoyenneDTO(MoyenneDTO moyenneDTO) {
        if (moyenneDTO == null) {
            return null;
        }

        Moyenne moyenne = new Moyenne();
        BeanUtils.copyProperties(moyenneDTO, moyenne);
        return moyenne;
    }


    public EleveDTO toDTO(Eleve eleve) {
        if (eleve == null) {
            return null;
        }

        EleveDTO dto = new EleveDTO();
        dto.setIdel(eleve.getIdel());
        dto.setFirstname(eleve.getFirstname());
        dto.setSecondname(eleve.getSecondname());
        dto.setAddrese(eleve.getAddrese());
        dto.setGmail(eleve.getGmail());
        dto.setPhoto(eleve.getPhoto());
        dto.setNiveau(eleve.getNiveau() != null ? eleve.getNiveau().name() : null); // Assurez-vous que Niveau est converti en String
        dto.setId_classe(eleve.getClasse() != null ? eleve.getClasse().getId_classe(): null);
        if (eleve.getCode() == null )
        {
            dto.setCode( eleve.generateCode() );
        }
        else {
            dto.setCode(eleve.getCode());
        }

        return dto;
    }
    public Matiere fromMatiereDTO(MatiereDTO matiereDTO) {
        if (matiereDTO == null) {
            return null;
        }

     Matiere matiere=new Matiere();
        BeanUtils.copyProperties(matiereDTO, matiere);
        return matiere;
    }

    public MatiereDTO fromMatiere(Matiere matiere) {
        if (matiere == null) {
            return null;
        }

     MatiereDTO matiereDTO=new MatiereDTO();
        BeanUtils.copyProperties(matiere, matiereDTO);
        return matiereDTO;
    }

}
