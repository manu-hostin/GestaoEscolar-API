package com.weg.gestaoEscolar.model;

import java.time.LocalDateTime;
import java.util.List;

public class Aula {

    private int id;
    private String nomeTurma;
    private LocalDateTime dataHota;
    private String assunto;

    public Aula(){}
    public Aula(int id, String nomeTurma, LocalDateTime dataHota, String assunto) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.dataHota = dataHota;
        this.assunto = assunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public LocalDateTime getDataHota() {
        return dataHota;
    }

    public void setDataHota(LocalDateTime dataHota) {
        this.dataHota = dataHota;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
