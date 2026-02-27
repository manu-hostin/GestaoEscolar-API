package com.weg.gestaoEscolar.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class Aluno {

    private int id;
    private int matricula;
    private String nome;
    private String email;
    private LocalDate nascimento;

    public Aluno() {
    }
    public Aluno(int id, int matricula, String nome, String email, LocalDate nascimento) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Aluno(int matricula, String nome, String email, LocalDate nascimento) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
