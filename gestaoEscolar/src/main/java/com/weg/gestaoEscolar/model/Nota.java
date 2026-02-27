package com.weg.gestaoEscolar.model;

public class Nota {

    private int id;
    private String nomeAluno;
    private String aulaAssunto;
    private double valor;

    public Nota(){}
    public Nota(int id, String nomeAluno, String aulaAssunto, double valor) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.aulaAssunto = aulaAssunto;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getAulaAssunto() {
        return aulaAssunto;
    }

    public void setAulaAssunto(String aulaAssunto) {
        this.aulaAssunto = aulaAssunto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
