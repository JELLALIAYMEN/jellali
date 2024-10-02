package com.example.gstioneleve.controller;

import com.example.gstioneleve.DTO.EleveDTO;
import com.example.gstioneleve.DTO.PayementDTO;
import com.example.gstioneleve.Service.InoteServiceimpl;
import com.example.gstioneleve.Service.Inoteservice;
import com.example.gstioneleve.Service.Iservice;
import com.example.gstioneleve.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PayController {
    @Autowired
    Iservice IserviceImpl;
    @Autowired
    Inoteservice InoteServiceimpl;

    @PostMapping(path = "/save-pay", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PayementDTO savePayement(
            @RequestParam("file") MultipartFile file,
           @RequestParam LocalDate date,
            @RequestParam("amount") Double amount,
            @RequestParam("typepay") Typepay typepay,
            @RequestParam("statuspay") Statuspay statuspay,
            @RequestParam("modepay") Modepay modepay,
            @RequestParam("modalitePay") ModalitePay modalitePay,
            @RequestParam("code") String code) throws IOException {
        return IserviceImpl.savePayement(file, date, amount, typepay, statuspay, modepay, modalitePay, code);
    }
    @GetMapping("/payments")
    public List<PayementDTO> getAllPayments(){
        return IserviceImpl.getAllPayments();

    }

    @GetMapping(path="payments/{id}/file",produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long id) throws IOException {
        return IserviceImpl.getPaymentFile(id);

    }

    @GetMapping("/status/{statuspay}")
    public List<PayementDTO> findPayementsByStatuspay(@PathVariable Statuspay statuspay) {
        return IserviceImpl.findPayementsByStatuspay(statuspay);
    }

    @PutMapping("/status/{paymentId}")
    public PayementDTO updatePaymentStatus(@RequestParam Statuspay statuspay, @PathVariable Long paymentId) {
        return IserviceImpl.updatePaymentStatus(statuspay, paymentId);
    }
    @GetMapping("/code/{code}")
    public List<PayementDTO> findByEleve_Code(@PathVariable String code) {
        return IserviceImpl.findByEleve_Code(code);
    }
    @GetMapping("/typepay/{typepay}")
    public List<PayementDTO> findPayementsByTypepay(@PathVariable Typepay typepay) {

        return IserviceImpl.findPayementsByTypepay(typepay);
    }


}