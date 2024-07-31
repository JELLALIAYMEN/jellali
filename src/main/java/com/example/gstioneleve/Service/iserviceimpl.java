package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.EleveDTO;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.PayementDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.Eleverep;
import com.example.gstioneleve.rep.Matiererep;
import com.example.gstioneleve.rep.Noterep;
import com.example.gstioneleve.rep.PayementRep;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class iserviceimpl implements Iservice {
    @Autowired
    Eleverep eleverep;
    @Autowired
    PayementRep payementRep;
    @Autowired
    Mapperdto dto;
    @Autowired
    Matiererep matiererep;
    @Autowired
    Noterep noterep;

    @Override
    public PayementDTO savePayement(MultipartFile file, LocalDate date, Double amount, Typepay typepay, Statuspay statuspay, Modepay modepay, ModalitePay modalitePay, String code) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-payec", "paymentec");
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"), "enset-payec", "paymentec", fileName + ".pdf");
        Files.copy(file.getInputStream(), filePath);

        Eleve eleve = eleverep.findByCode(code);
        if (eleve != null) {
            Payement payement = Payement.builder()
                    .date(date)
                    .amount(amount)
                    .eleve(eleve)
                    .statuspay(statuspay)
                    .modalitePay(modalitePay)
                    .typepay(typepay)
                    .modepay(modepay)
                    .file(filePath.toUri().toString())
                    .build();
            payementRep.save(payement);
            return dto.fromPayement(payement);
        }
        return null;
    }

    @Override
    public List<PayementDTO> getAllPayments() {
        List<Payement> payements=payementRep.findAll();
        return  payements.stream().map(dto::fromPayement).collect(Collectors.toList());
    }


    @Override
    public MatiereDTO saveMatiere(MatiereDTO matiereDTO) {
      Matiere matiere=dto.fromMatiereDTO(matiereDTO);
      Matiere savdm=matiererep.save(matiere);



        return  dto.fromMatiere(savdm);
    }

    @Override
    public List<EleveDTO> findAll() {
        List<Eleve> eleves = eleverep.findAll();
        return eleves.stream()
                .map(dto::fromEleve)
                .collect(Collectors.toList());
    }
@Override
    public List<Payement> findPayementsByStatuspay(Statuspay statuspay) {
      List<Payement> payements=payementRep.findPayementsByStatuspay(statuspay);
      return payementRep.findAll();
    }

    @Override
    public List<Payement> findByEleve_Code(String code) {
      return payementRep.findByEleve_Code(code);
    }

    @Override
    public List<Payement> findPayementsByTypepay(Typepay typepay) {
        List<Payement> payements=payementRep.findPayementsByTypepay(typepay);
        return payementRep.findAll();
    }



    @Override
    public EleveDTO saveEleve(MultipartFile photo, String firstname, String secondname, String gmail, Cycle cycle, String addresse) throws IOException {
        // Définir le chemin de stockage des fichiers
        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-payec", "paymentec");
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        // Générer un nom de fichier unique pour éviter les collisions
        String fileName = UUID.randomUUID().toString();
        Path filePath = folderPath.resolve(fileName + ".pdf");

        // Copier le fichier photo dans le chemin de stockage
        try (InputStream inputStream = photo.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        // Créer un objet Eleve avec les informations fournies
        Eleve eleve = Eleve.builder()
                .firstname(firstname)
                .secondname(secondname)
                .addrese(addresse)
                .gmail(gmail)
                .cycle(cycle)
                .photo(filePath.toUri().toString()) // Stocker le chemin du fichier sous forme d'URI
                .build();

        // Sauvegarder l'objet Eleve dans la base de données
        eleverep.save(eleve);

        // Convertir l'objet Eleve en EleveDTO et le retourner
        return dto.fromEleve(eleve);
    }

    @Override
    public byte[] getPaymentFile(Long id) throws IOException {
        Payement payment = payementRep.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }

    @Override
    public Payement updatePaymentStatus(Statuspay statuspay, Long paymentId) {
        Payement payment =payementRep.findById(paymentId).get();
        payment.setStatuspay(statuspay);
        return payementRep.save(payment);
    }

    @Override
    public void deleteEleve(Long id) {
        eleverep.deleteById(id);
    }

//    @Override
//    public List<EleveDTO> findByCycle(Cycle cycle) {
//        List<Eleve> eleves=eleverep.findByCycle(cycle);
//      return   eleves.stream().map(eleve->dto.fromEleve(eleve)).collect(Collectors.toList());
//    }


}











