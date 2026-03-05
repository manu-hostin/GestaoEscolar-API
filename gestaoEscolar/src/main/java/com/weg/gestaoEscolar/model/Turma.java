package com.weg.gestaoEscolar.model;

public class Turma {

    private int id;
    private String nome;
    private int cursoId;
    private int professorId;

    public Turma(){}

    public Turma(int id, String nome, int cursoId, int professorId) {
        this.id = id;
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
    }

    public Turma(String nome, int cursoId, int professorId) {
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
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

    public int getCursoId() {
        return cursoId;
    }

    public int getProfessorId() {
        return professorId;
    }
}