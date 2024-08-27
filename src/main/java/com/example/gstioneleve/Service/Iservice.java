package com.example.gstioneleve.Service;


import com.example.gstioneleve.DTO.CoursDTO;
import com.example.gstioneleve.DTO.EleveDTO;
import com.example.gstioneleve.DTO.MatiereDTO;
import com.example.gstioneleve.DTO.PayementDTO;
import com.example.gstioneleve.entites.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public interface Iservice {


 public PayementDTO savePayement(MultipartFile file, LocalDate date, Double amount, Typepay typepay, Statuspay statuspay, Modepay modepay, ModalitePay modalitePay, String code) throws IOException;

public   List<PayementDTO> getAllPayments();



    List<Payement> findPayementsByStatuspay(Statuspay statuspay);

    List<Payement> findByEleve_Code(String code);
    public  EleveDTO findByCode(String code);


    List<EleveDTO> findAll();

    List<Payement> findPayementsByTypepay(Typepay typepay);


    public EleveDTO saveEleve(MultipartFile photo, String firstname, String secondname, String gmail, String addresse
                              ) throws IOException;
    public byte[] getPaymentFile(Long id) throws IOException;
    public Payement updatePaymentStatus(Statuspay statuspay, Long paymentId);
void deleteEleve(Long id);




}
