package com.weg.gestaoEscolar.model;

import java.sql.Date;

public class Nota {
    private Long id;
    private Long alunoId;
    private Long aulaId;
    private Double valor;

    public Nota() {}

    public Nota(Long id, Long alunoId, Long aulaId, Double valor) {
        this.id = id;
        this.alunoId = alunoId;
        this.aulaId = aulaId;
        this.valor = valor;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public Long getAulaId() { return aulaId; }
    public void setAulaId(Long aulaId) { this.aulaId = aulaId; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}