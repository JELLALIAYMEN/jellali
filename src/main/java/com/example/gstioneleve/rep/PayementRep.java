package com.example.gstioneleve.rep;

import com.example.gstioneleve.entites.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PayementRep  extends JpaRepository<Payement,Long> {
    List<Payement> findByEleve_Code(String code);


    public List<Payement> findByTypepay(Typepay typepay);


    List<Payement> findPayementsByStatuspay(Statuspay statuspay);

    List<Payement> findPayementsByTypepay(Typepay typepay);
}
