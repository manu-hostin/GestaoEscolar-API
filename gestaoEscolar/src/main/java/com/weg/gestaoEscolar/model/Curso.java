package com.weg.gestaoEscolar.model;

import java.util.List;

public class Curso {

    private int id;
    private String nome;
    private int codigo;
    private List<Professor> nomesProfessores;

    public Curso(){}

    public Curso(int id, String nome, int codigo, List<Professor> nomesProfessores) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.nomesProfessores = nomesProfessores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Professor> getNomesProfessores() {
        return nomesProfessores;
    }

    public void setNomesProfessores(List<Professor> nomesProfessores) {
        this.nomesProfessores = nomesProfessores;
    }
}
