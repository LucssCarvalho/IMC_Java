package com.carvalho.imcjavaapp.model;

import java.io.Serializable;

public class imcRecord implements Serializable {

    private double imc;
    private String infoImc;

    public imcRecord(double imc, String infoImc) {
       this.imc = imc;
       this.infoImc = infoImc;
    }
}
