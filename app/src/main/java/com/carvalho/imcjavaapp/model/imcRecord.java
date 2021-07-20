package com.carvalho.imcjavaapp.model;

import java.io.Serializable;

public class imcRecord implements Serializable {

    public String imc;
    public String infoImc;

    public imcRecord(String imc, String infoImc) {
       this.imc = imc;
       this.infoImc = infoImc;
    }
}
