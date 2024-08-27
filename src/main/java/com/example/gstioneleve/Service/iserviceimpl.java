package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.EleveDTO;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.PayementDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.*;
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
import java.util.Optional;
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
    CoursRep coursRep;

    @Override
    public PayementDTO savePayement(MultipartFile file, LocalDate date, Double amount, Typepay typepay, Statuspay statuspay, Modepay modepay, ModalitePay modalitePay, String code) throws IOException {
        // Définir le chemin du dossier pour le fichier
        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-payec", "paymentec");
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        // Définir le nom du fichier et le chemin complet
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(folderPath.toString(), fileName + ".pdf");

        // Copier le fichier à partir du MultipartFile
        Files.copy(file.getInputStream(), filePath);

        // Trouver l'élève par son code
        Optional<Eleve> eleveOptional = eleverep.findByCode(code);
        if (eleveOptional.isPresent()) {
            Eleve eleve = eleveOptional.get();

            // Créer un objet Payement avec les données fournies
            Payement payement = Payement.builder()
                    .date(date)
                    .amount(amount)
                    .statuspay(statuspay)
                    .modalitePay(modalitePay)
                    .typepay(typepay)
                    .modepay(modepay)
                    .file(filePath.toUri().toString())
                    .eleve(eleve)  // Associer l'élève au paiement
                    .build();

            // Sauvegarder le paiement dans la base de données
            payementRep.save(payement);

            // Convertir l'entité Payement en PayementDTO et la retourner
            return dto.fromPayement(payement);
        }

        // Retourner null si l'élève n'est pas trouvé
        return null;
    }

    @Override
    public List<PayementDTO> getAllPayments() {
        List<Payement> payements=payementRep.findAll();
        return  payements.stream().map(dto::fromPayement).collect(Collectors.toList());
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
    public EleveDTO findByCode(String code) {
        Optional<Eleve> eleveOptional = eleverep.findByCode(code);
        return eleveOptional.map(dto::fromEleve).orElseGet(() -> new EleveDTO());





    }

    @Override
    public List<Payement> findPayementsByTypepay(Typepay typepay) {
        List<Payement> payements=payementRep.findPayementsByTypepay(typepay);
        return payementRep.findAll();
    }



    @Override
    public EleveDTO saveEleve(MultipartFile photo, String firstname, String secondname, String gmail, String addresse) throws IOException {
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
                .addresse(addresse)
                .gmail(gmail)
                .photo(filePath.toString()) // Stocker le chemin du fichier sous forme de String
              // Associer l'option à l'élève
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





}











