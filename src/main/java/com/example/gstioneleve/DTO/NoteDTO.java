package com.example.gstioneleve.DTO;

import com.example.gstioneleve.entites.Eleve;
import com.example.gstioneleve.entites.Periode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NoteDTO {
    private  Long idnote;

    private  String code;
    private  Double noteControleContinue;
    private Double  noteexamencontrole1;
    private Double noteexamencontrole2;
    private  Double  noteeexamenSynthése;
    private Long idmatiere;
    private Periode periode;

}
