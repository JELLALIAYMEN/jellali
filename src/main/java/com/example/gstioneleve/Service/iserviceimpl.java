package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.EleveDTO;

import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.PayementDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.*;
import com.example.gstioneleve.rep.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@Transactional
public class iserviceimpl implements Iservice {
    private static final Logger logger = LoggerFactory.getLogger(iserviceimpl.class);
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
    @Autowired
    Classerep classerep;
    @Override
    public EleveDTO saveEleve(MultipartFile photo, String firstname, String secondname, String gmail, Niveau niveau, String address, Long id_classe) throws IOException {
        try {
            // Define the storage path for files
            Path folderPath = Paths.get(System.getProperty("user.home"), "enset-payec", "paymentec");
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            // Generate a unique filename to avoid collisions
            String fileName = UUID.randomUUID().toString();
            Path filePath = folderPath.resolve(fileName + ".pdf");

            // Copy the photo file to the storage path
            try (InputStream inputStream = photo.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }

            // Fetch the Classe by idClasse
            Classe classe = classerep.findById(id_classe)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid class ID: " + id_classe));
            String code = UUID.randomUUID().toString();
            System.out.println("COdeeeeeeeeeeeeeeeeeeeeee : " + code) ;

            // Create an Eleve object with the provided information
            Eleve eleve = Eleve.builder()
                    .firstname(firstname)
                    .secondname(secondname)
                    .addrese(address)
                    .gmail(gmail)
                    .code(code)
                    .niveau(niveau) // Directly use the Niveau enum
                    .photo(filePath.toUri().toString())
                    .classe(classe)  // Assign the class to the Eleve
                    .build();

            // Save the Eleve object to the database
            Eleve savedEleve = eleverep.save(eleve);

            // Convert the saved Eleve to EleveDTO and return it
            return dto.toDTO(savedEleve); // Use fromEleve to convert to DTO

        } catch (Exception e) {
            // Log the error for debugging
            logger.error("Error saving student: {}", e.getMessage(), e);

            // Optionally rethrow or return a meaningful error message
            throw new RuntimeException("Error saving student: " + e.getMessage(), e);
        }
    }

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
                    .eleve(eleve) // Conservez ici l'objet Eleve si nécessaire pour la base de données
                    .statuspay(statuspay)
                    .modalitePay(modalitePay)
                    .typepay(typepay)
                    .modepay(modepay)
                    .file(filePath.toUri().toString())
                    .build();
            payementRep.save(payement);

            // Créez le PayementDTO avec le code de l'élève
            return PayementDTO.builder()
                    .id(payement.getId())
                    .amount(amount)
                    .date(date)
                    .typepay(typepay)
                    .modepay(modepay)
                    .statusPay(statuspay)
                    .file(filePath.toUri().toString())
                    .code(eleve.getCode()) // Utilisez le code de l'élève
                    .build();
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
                .map(dto::toDTO)
                .collect(Collectors.toList());
    }
@Override
    public List<PayementDTO> findPayementsByStatuspay(Statuspay statuspay) {
      List<Payement> payements=payementRep.findPayementsByStatuspay(statuspay);
      return  payements.stream().map(payement -> dto.fromPayement(payement)).collect(Collectors.toList());
    }

    @Override
    public List<PayementDTO> findByEleve_Code(String code) {
        Eleve eleve = eleverep.findByCode(code);
        if (eleve != null) {

            List<Payement> payements = eleve.getPayements();
            return payements.stream().map(payement -> dto.fromPayement(payement)).collect(Collectors.toList());
        }
        return  null;
    }
    @Override
    public List<PayementDTO> findPayementsByTypepay(Typepay typepay) {
        List<Payement> payements=payementRep.findPayementsByTypepay(typepay);

         return  payements.stream().map(payement -> dto.fromPayement(payement)).collect(Collectors.toList());
    }






    @Override
    public byte[] getPaymentFile(Long id) throws IOException {
        Payement payment = payementRep.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }

    @Override
    public PayementDTO updatePaymentStatus(Statuspay statuspay, Long paymentId) {
        Payement payment =payementRep.findById(paymentId).get();
        payment.setStatuspay(statuspay);
     payementRep.save(payment);
     return  dto.fromPayement(payment);
    }

    @Override
    public Eleve findById(Long idel) {
        return eleverep.findById(idel).orElse(null);



    }

    @Override
    public void deleteEleve(Long id) {
        eleverep.deleteById(id);
    }




}











