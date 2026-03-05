package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.professor.ProfessorRequisicao;
import com.weg.gestaoEscolar.DTO.professor.ProfessorResposta;
import com.weg.gestaoEscolar.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/escola/professores")
public class ProfessorController {

    private final ProfessorService service;
    public ProfessorController (ProfessorService service) {
        this.service = service;
    }

    @PostMapping ("/cadastrar")
    public ProfessorResposta cadastrarProfessor (@RequestBody ProfessorRequisicao requisicao){
        try {
            return service.cadastrarProfessor(requisicao);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping ("/listar")
    public List<ProfessorResposta> listarProfessores () {
        try {
            return service.listarProfessores();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping ("/listar/{id}")
    public ProfessorResposta listarProfessores (@PathVariable int id) {
        try {
            return service.listarProfessor(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping ("/atualizar/{id}")
    public ProfessorResposta atualizarProfessor (@RequestBody ProfessorRequisicao requisicao, @PathVariable int id){
        try {
            return service.atualizarProf(requisicao, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping ("/deletar/{id}")
    public String deletarProfessor (@PathVariable int id) {
        try {
            return service.deletarProfessor(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
