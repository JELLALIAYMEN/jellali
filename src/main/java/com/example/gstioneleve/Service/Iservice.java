package com.example.gstioneleve.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.gstioneleve.DTO.EleveDTO;
import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.PayementDTO;
import com.example.gstioneleve.entites.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface Iservice {

  Eleve findById(Long idel);

   //veEleve(MultipartFile photo, String firstname, String secondname, String gmail, String niveauStr, String address, Long id_classe) throws IOException;

    PayementDTO savePayement(MultipartFile file, LocalDate date, Double amount, Typepay typepay, Statuspay statuspay, Modepay modepay, ModalitePay modalitePay, String code) throws IOException;

    List<PayementDTO> getAllPayments();

    MatiereDTO saveMatiere(MatiereDTO matiereDTO);

    List<PayementDTO> findPayementsByStatuspay(Statuspay statuspay);

    List<PayementDTO> findByEleve_Code(String code);

    List<EleveDTO> findAll();

    List<PayementDTO> findPayementsByTypepay(Typepay typepay);


    EleveDTO saveEleve(MultipartFile photo, String firstname, String secondname, String gmail, Niveau niveau, String address, Long id_classe) throws IOException;

    byte[] getPaymentFile(Long id) throws IOException;

    PayementDTO updatePaymentStatus(Statuspay statuspay, Long paymentId);

    void deleteEleve(Long id);


}
