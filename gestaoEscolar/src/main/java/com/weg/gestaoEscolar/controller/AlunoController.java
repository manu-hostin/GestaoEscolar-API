package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/escola/aluno")
public class AlunoController {


    private final AlunoService service;
    public AlunoController (AlunoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public AlunoResposta cadastrarAluno (@RequestBody AlunoRequisicao alunoRequisicao){

        try {
             return service.cadastrarUsuario(alunoRequisicao);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<AlunoResposta> listarAlunos () {
        try {
            return service.listarAlunos();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar/{id}")
    public AlunoResposta listarAlunoID (@PathVariable int id) {
        try {
            return service.listarAlunoID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public AlunoResposta atualizarAluno (@RequestBody AlunoRequisicao requisicao, @PathVariable int id) {
        try {
            return service.atualizarAluno(requisicao, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarAluno (@PathVariable int id){
        try {
            return service.deletarAluno(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
