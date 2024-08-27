package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.MoyenneDTO;
import com.example.gstioneleve.DTO.NoteDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import com.example.gstioneleve.rep.MoyenneRep;
import com.example.gstioneleve.rep.Noterep;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MoyenneServiceimpl implements MoyenneService {
    @Autowired
    Eleverep eleverep;
    @Autowired
    Mapperdto mapperdto;
    @Autowired
    Matiererep Matiererep;
    @Autowired
    MoyenneRep moyenneRep;


    @Override
    public MoyenneDTO calculerMoyenneTrimestrielle(Long eleveId, Trimestre trimestre) {
        try {
            // Récupération de l'élève
            Eleve eleve = eleverep.findById(eleveId)
                    .orElseThrow(() -> new RuntimeException("Élève non trouvé"));

            // Filtrage des notes pour le trimestre
            List<NoteDTO> notesEleveTrimestre = eleve.getNotes().stream()
                    .filter(note -> note.getTrimestre() == trimestre)
                    .map(mapperdto::fromNote)
                    .collect(Collectors.toList());

            // Récupération des matières
            List<Matiere> matieres = Matiererep.findAll();
            if (matieres == null || matieres.isEmpty()) {
                throw new RuntimeException("Aucune matière trouvée");
            }

            // Regroupement des notes par matière
            Map<Long, List<NoteDTO>> notesParMatiere = notesEleveTrimestre.stream()
                    .collect(Collectors.groupingBy(NoteDTO::getMatiereId));

            double totalMoyennePonderee = 0;
            double totalCoef = 0;

            for (Map.Entry<Long, List<NoteDTO>> entry : notesParMatiere.entrySet()) {
                Long matiereId = entry.getKey();
                List<NoteDTO> notesPourMatiere = entry.getValue();

                // Trouver le coefficient de la matière
                Matiere matiereDTO = matieres.stream()
                        .filter(matiere -> matiere.getMatiereId().equals(matiereId))
                        .findFirst()
                        .orElse(null);

                if (matiereDTO == null) {
                    // Loguer ou gérer le cas où la matière n'est pas trouvée
                    System.out.println("Matière avec ID " + matiereId + " non trouvée");
                    continue; // Passer à la prochaine matière
                }

                double coef = matiereDTO.getCoefficient();
                double sommeNotes = notesPourMatiere.stream().mapToDouble(NoteDTO::getValeur).sum();
                int nombreNotes = notesPourMatiere.size();
                double moyennePourMatiere = nombreNotes > 0 ? sommeNotes / nombreNotes : 0;

                totalMoyennePonderee += moyennePourMatiere * coef;
                totalCoef += coef;
            }

            double moyenneTrimestrielle = totalCoef > 0 ? totalMoyennePonderee / totalCoef : 0;
            moyenneTrimestrielle = Math.round(moyenneTrimestrielle * 100.0) / 100.0;

            return MoyenneDTO.builder()
                    .id(eleveId)
                    .matiereId(null) // Null ici car c'est une moyenne globale
                    .code(String.valueOf(eleveId))
                    .moyennevalue(moyenneTrimestrielle)
                    .moyenneType(MoyenneType.moyenneTrimestrielle1)
                    .build();
        } catch (Exception e) {
            e.printStackTrace(); // Afficher les détails de l'exception pour le débogage
            throw new RuntimeException("Erreur lors du calcul de la moyenne trimestrielle", e);
        }
    }

    @Override
    public MoyenneDTO calculerMoyenneAnnuelle(Long eleveId) {
        try {
            // Récupération de l'élève
            Eleve eleve = eleverep.findById(eleveId)
                    .orElseThrow(() -> new RuntimeException("Élève non trouvé"));

            // Calcul des moyennes trimestrielles
            double moyenneTrimestre1 = calculerMoyenneTrimestrielle(eleveId, Trimestre.TRIMESTRE_1).getMoyennevalue();
            double moyenneTrimestre2 = calculerMoyenneTrimestrielle(eleveId, Trimestre.TRIMESTRE_2).getMoyennevalue();
            double moyenneTrimestre3 = calculerMoyenneTrimestrielle(eleveId, Trimestre.TRIMESTRE_3).getMoyennevalue();

            // Calcul de la moyenne annuelle
            double moyenneAnnuelle = (moyenneTrimestre1 + moyenneTrimestre2 + moyenneTrimestre3) / 3.0;
            moyenneAnnuelle = Math.round(moyenneAnnuelle * 100.0) / 100.0; // Arrondir à deux décimales

            // Retourner le résultat sous forme de DTO
            return MoyenneDTO.builder()
                    .id(eleveId)
                    .matiereId(null) // Null ici car c'est une moyenne globale
                    .code(String.valueOf(eleveId))
                    .moyennevalue(moyenneAnnuelle)
                    .moyenneType(MoyenneType.moyenneAnnuelle)
                    .build();
        } catch (Exception e) {
            e.printStackTrace(); // Afficher les détails de l'exception pour le débogage
            throw new RuntimeException("Erreur lors du calcul de la moyenne annuelle", e);
        }
    }

    @Override
    public void update(long id, MoyenneDTO moyenneDTO) {

    Moyenne  moyenne=moyenneRep.findById(id).orElse(null);


        if (moyenne != null) {
          moyenne.setMoyenneType(moyenneDTO.getMoyenneType());
        moyenne.setMoyennevalue(moyenneDTO.getMoyennevalue());
moyenneRep.save(moyenne);


        } else {
            // Handle the case where the entity is not found.
            // You might want to throw an exception or handle it according to your application's needs.
            throw new EntityNotFoundException("Cours with ID " + id + " not found.");
        }
    }

    @Override
    public List<MoyenneDTO> findByEl(String code) {
      Eleve eleve=eleverep.findByCode(code).orElse(null);
      List<Moyenne> moyennes=eleve.getMoyennes();
        return moyennes.stream()
                .map(moyenne -> mapperdto.fromMoyenne(moyenne))
                .collect(Collectors.toList());
    }
}

