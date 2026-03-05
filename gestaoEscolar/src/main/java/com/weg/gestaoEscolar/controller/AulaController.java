package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.DTO.aula.AulaRequisicao;
import com.weg.gestaoEscolar.DTO.aula.AulaResposta;
import com.weg.gestaoEscolar.service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/escola/aulas")
public class AulaController {

    private final AulaService service;
    public AulaController (AulaService service){
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public AulaResposta cadastrarAula (@RequestBody AulaRequisicao requisicao){
        try {
            return service.cadastrarAula(requisicao);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/listar")
    public List<AulaResposta> listarAula () {
        try {
            return service.listarAulas();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar/{id}")
    public AulaResposta listarAulaID (@PathVariable int id) {
        try {
            return service.listarAulaID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public AulaResposta atualizarAula (@RequestBody AulaRequisicao requisicao, @PathVariable int id) {
        try {
            return service.atualizarAula(requisicao, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarAula (@PathVariable int id){
        try {
            return service.deletarAula(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
