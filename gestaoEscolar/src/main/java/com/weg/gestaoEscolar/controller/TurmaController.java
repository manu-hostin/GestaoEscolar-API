package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.turma.TurmaRequisicao;
import com.weg.gestaoEscolar.DTO.turma.TurmaResposta;
import com.weg.gestaoEscolar.model.Turma;
import com.weg.gestaoEscolar.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/escola/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService){
        this.turmaService = turmaService;
    }

    @PostMapping("/cadastrar")
    public Turma cadastrar(@RequestBody Turma turma) throws SQLException {
        return turmaService.cadastrar(turma);
    }

    @GetMapping("/listar")
    public List<Turma> listar() throws SQLException {
        return turmaService.listar();
    }

    @PutMapping("/atualizar/{id}")
    public Turma atualizar(@PathVariable Long id, @RequestBody Turma turma) throws SQLException {
        return turmaService.atualizar(id, turma);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) throws SQLException {
        return turmaService.deletar(id);
    }
}