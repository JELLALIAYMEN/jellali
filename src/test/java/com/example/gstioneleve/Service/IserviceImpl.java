//package com.example.gstioneleve.Service;
//
//import com.example.gstioneleve.DTO.EleveDTO;
//import com.example.gstioneleve.Mapper.Mapperdto;
//import com.example.gstioneleve.entites.*;
//import com.example.gstioneleve.rep.Eleverep;
//import com.example.gstioneleve.rep.PayementRep;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.net.URI;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class implements Iservice {
//    @Autowired
//    Eleverep eleverep;
//
//    @Autowired
//    PayementRep payementRep;
//
//    @Autowired
//    Mapperdto dto;
//
//    @Override
//    public Payement savePayement(MultipartFile file, LocalDate date, Double amount, Typepay typepay, Statuspay statuspay, Modepay modepay, ModalitePay modalitePay, String code) throws IOException {
//        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-students", "payments");
//        if (!Files.exists(folderPath)) {
//            Files.createDirectories(folderPath);
//        }
//        String fileName = UUID.randomUUID().toString();
//        Path filePath = Paths.get(System.getProperty("user.home"), "enset-students", "payments", fileName + ".pdf");
//        Files.copy(file.getInputStream(), filePath);
//        Eleve eleve = eleverep.findByCode(code);
//        if (eleve != null) {
//            Payement payment = Payement.builder()
//                    .statuspay(statuspay)
//                    .modalitePay(modalitePay)
//                    .amount(amount)
//                    .date(date)
//                    .modepay(modepay)
//                    .modalitePay(modalitePay)
//                    .elevee(eleve)
//                    .file(filePath.toUri().toString())
//                    .build();
//            return payementRep.save(payment);
//        }
//        return null;
//    }
//
//    @Override
//    public List<Payement> getAllPayments() {
//        return payementRep.findAll();
//    }
//
//    @Override
//    public EleveDTO saveEleve(MultipartFile photo, MultipartFile file, String firstname, String secondname, String gmail, Cycle cycle, String addresse) throws IOException {
//        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-el", "el");
//        if (!Files.exists(folderPath)) {
//            Files.createDirectories(folderPath);
//        }
//
//        String fileName = UUID.randomUUID().toString();
//        Path filePath = folderPath.resolve(fileName + ".pdf");
//        Files.copy(file.getInputStream(), filePath);
//
//        Eleve eleve = Eleve.builder()
//                .addrese(addresse)
//                .gmail(gmail)
//                .cycle(cycle)
//                .firstname(firstname)
//                .secondname(secondname)
//                .photo(photo != null ? photo.getOriginalFilename() : null)
//                .build();
//
//        eleverep.save(eleve);
//
//        return dto.fromEleve(eleve);
//    }
//
//    @Override
//    public Payement updatePaymentStatus(Statuspay status, Long paymentId) {
//        Payement payment = payementRep.findById(paymentId).orElse(null);
//        if (payment != null) {
//            payment.setStatuspay(status);
//            return payementRep.save(payment);
//        }
//        return null;
//    }
//
//    @Override
//    public List<Payement> findPayementsByStatuspay(String statuspay) {
//        return payementRep.findPayementsByStatuspay(Statuspay.valueOf(statuspay));
//    }
//
//    @Override
//    public byte[] getPaymentFile(Long id) throws IOException {
//        Payement payment = payementRep.findById(id).orElse(null);
//        if (payment != null) {
//            return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
//        }
//        return null;
//    }
//
//}
