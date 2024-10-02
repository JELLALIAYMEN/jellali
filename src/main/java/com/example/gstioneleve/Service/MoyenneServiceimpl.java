package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.Exp.StudentNotFoundException;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import com.example.gstioneleve.rep.MoyenneRep;
import com.example.gstioneleve.rep.Noterep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoyenneServiceimpl implements Moyenneservice {

    @Autowired
    private MoyenneRep moyenneRep;

    @Autowired
    private Mapperdto dto;
    @Autowired
    Noterep noterep;
    @Autowired
    Matiererep matiererep;
    @Autowired

    Moyenneservice  MoyenneServiceimpl;
    @Autowired
    private Eleverep eleverep;



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
    public MoyenneDTO saveMoyenne(MoyenneDTO moyenneDTO) {
       Moyenne moyenne=dto.fromMoyenneDTO(moyenneDTO);
          Moyenne savedMo=moyenneRep.save(moyenne);
           return  dto.fromMoyenne(savedMo);





    }

    @Override
    public void deleteMoyenne(Long idMoyenne) {
        moyenneRep.deleteById(idMoyenne);
    }

    @Override
    public double calculerMoyenneTrimestrielleParEleve(Long idel, Trimestre trimestre) {
        // Retrieve student and their class
        Eleve e = eleverep.findById(idel).orElseThrow(() -> new StudentNotFoundException("Élève non trouvé pour l'ID: " + idel));
        Classe classe = e.getClasse();
        if (classe == null) {
            throw new IllegalArgumentException("L'élève n'appartient à aucune classe.");
        }

        // Fetch subjects related to the student
        List<Matiere> matieres = matiererep.findMatieresByEleveId(idel);

        if (matieres.isEmpty()) {
            throw new RuntimeException("Aucune matière trouvée pour l'élève.");
        }

        double weightedSum = 0.0;
        double totalSubjectCoefficients = 0.0;

        // Calculate the weighted average for each subject
        for (Matiere matiere : matieres) {
            Double subjectCoefficient = matiere.getCoff();

            // Ensure the subject has a valid coefficient
            if (subjectCoefficient == null || subjectCoefficient == 0) {
                throw new IllegalArgumentException("Coefficient invalide pour la matière : " + matiere.getNom());
            }

            // Calculate the subject average for this trimester
            double subjectAverage = calculerMoyenneTrimestrielleParMatiere(idel, matiere.getId_matiere(), trimestre);
          //  System.out.println("-------------------------------------------------------------------") ;
         //System.out.println( "Matiere : " + matiere.getNom() + " Coeff : "  + matiere.getCoff()   +"Moyenne mat : " + subjectAverage ) ;
            // Accumulate weighted averages
            weightedSum += subjectAverage * subjectCoefficient;
            totalSubjectCoefficients += subjectCoefficient;
        }
        double moyEleveTrim = totalSubjectCoefficients > 0 ? weightedSum / totalSubjectCoefficients : 0;


        Moyenne moy = moyenneRep.findByEleveAndTrimestre(eleverep.findById(idel).get() ,trimestre);

        if (moy ==  null ) {
            moy = new Moyenne();
        }
        moy.setMoyenneType(moyTypeMapper(trimestre));
        moy.setEleve(eleverep.findById(idel).get());
        moy.setTrimestre(trimestre );
        moy.setMoyennevalue(moyEleveTrim);
        moyenneRep.save(moy);

        return moyEleveTrim ;
        // Calculate final trimester average
    }



    @Override
    public double calculerMoyenneTrimestrielleParMatiere(Long  idel,Long id_matiere, Trimestre trimestre) {

Matiere matiere=matiererep.findById(id_matiere).orElse(null);
        if (matiere == null) {
            throw new RuntimeException("Matière non trouvée pour l'ID: " + id_matiere);
        }
        List<Note> notes =noterep.findByEleve_IdelAndMatiere_idAndTrimestre( idel,  id_matiere,  trimestre);
       double totalNotes = 0;
       double totalCoefficients = 0;
       double moyEleveTrim = 0 ;

        for (Note note : notes) {
           double coefficientNote = 1;
           if (note.getTypeNote() == TypeNote.NOTE_EXAMEN_SYNTHÈSE) {
               coefficientNote = 2; // Coefficient spécial pour les examens de synthèse
          }
            if (note.getTypeNote() == TypeNote.NOTE_TP) {
                coefficientNote = 1; // Coefficient spécial pour les examens de synthèse
            }
            if (note.getTypeNote() == TypeNote.NOTE_CONTROLE_CONTINUE) {
                coefficientNote = 1; // Coefficient spécial pour les examens de synthèse
            }
            if (note.getTypeNote() == TypeNote.NOTE_EXAMEN_CONTROLE1) {
                coefficientNote = 1; // Coefficient spécial pour les examens de synthèse
            }
            if (note.getTypeNote() == TypeNote.NOTE_EXAMEN_CONTROLE2) {
                coefficientNote = 1; // Coefficient spécial pour les examens de synthèse
            }
          // Calcul de la pondération : valeur de la note * coefficient de la note * coefficient de la matière
           double pondération = note.getNoteValue() * coefficientNote * matiere.getCoff();
            totalNotes += pondération;

         // Coefficient global : coefficient de la note * coefficient de la matière
            totalCoefficients += coefficientNote * matiere.getCoff();
       }


       // Calcul de la moyenne pondérée
        moyEleveTrim =  totalCoefficients > 0 ? totalNotes / totalCoefficients : 0;
        Moyenne moy = moyenneRep.findByEleveAndTrimestre(eleverep.findById(idel).get() ,trimestre);
/*
        if (moy ==  null ) {
            moy = new Moyenne();
        }
        moy.setMoyenneType(MoyenneType.moyenneMatiere);
        moy.setEleve(eleverep.findById(idel).get());
        moy.setTrimestre(trimestre );
        moy.setMoyennevalue(moyEleveTrim);
        moyenneRep.save(moy);*/

        return moyEleveTrim ;
   }


    public  MoyenneType moyTypeMapper (Trimestre trimestre) {
        switch (trimestre) {
            case Trimestre1 -> {
                return MoyenneType.moyenneTrimestrielle1;

            }
            case Trimestre2 -> {
                return MoyenneType.moyenneTrimestrielle2;

            }
            case Trimestre3 -> {
                return MoyenneType.moyenneTrimestrielle3;

            }
            default -> {
                return MoyenneType.moyenneTrimestrielle1 ;
            }
        }

    }

    public  int coeffMapper (Trimestre trimestre) {
        switch (trimestre) {
            case Trimestre1 -> {
                return 1;

            }
            case Trimestre2 -> {
                return 2;

            }
            case Trimestre3 -> {
                return 2;

            }
            default -> {
                return 1 ;
            }
        }

    }





    @Override
    public double calculerMoyenneAnnuelle(Long eleveId) {
        Trimestre[] trimestres = Trimestre.values();

        double sommePonderee = 0;
        int totalCoefficients = 0;



        for (Trimestre trimestre : trimestres) {
            // Calculer la moyenne trimestrielle
            double moyenneTrimestrielle = calculerMoyenneTrimestrielleParEleve(eleveId, trimestre);

            // Si vous avez des coefficients pour les trimestres, appliquez-les
            double coefficientTrimestre = coeffMapper(trimestre); // Mettre à jour selon vos besoins

            // Ajouter à la somme pondérée
            sommePonderee += moyenneTrimestrielle * coefficientTrimestre;
            totalCoefficients += coefficientTrimestre;
            System.out.println("-------------------------------------------------------------------") ;
            System.out.println( "Trimestre : " + trimestre + " Coeff : "  + coefficientTrimestre   +"moyenne trimestre : " + moyenneTrimestrielle+  "Somme pondérée : " + sommePonderee  + " totalCoefficient : " + totalCoefficients ) ;
        }

        // Retourner la moyenne annuelle
        return totalCoefficients > 0 ? sommePonderee / totalCoefficients : 0;
    }




    }







