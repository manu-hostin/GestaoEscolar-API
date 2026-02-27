package com.weg.gestaoEscolar.model;

import java.util.List;

public class Turma {

    private int id;
    private String nome;
    private String nomeCurso;
    private String nomeProf;
    private List<Aluno> nomeAlunos;

    public Turma(){}
    public Turma(int id, String nome, String nomeCurso, String nomeProf, List<Aluno> nomeAlunos) {
        this.id = id;
        this.nome = nome;
        this.nomeCurso = nomeCurso;
        this.nomeProf = nomeProf;
        this.nomeAlunos = nomeAlunos;
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

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public List<Aluno> getNomeAlunos() {
        return nomeAlunos;
    }

    public void setNomeAlunos(List<Aluno> nomeAlunos) {
        this.nomeAlunos = nomeAlunos;
    }
}
