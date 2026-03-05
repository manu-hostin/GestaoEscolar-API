package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.nota.NotaRequisicao;
import com.weg.gestaoEscolar.DTO.nota.NotaResposta;
import com.weg.gestaoEscolar.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/escola/nota")
public class NotaController {

    private final NotaService service;
    public NotaController(NotaService service) { this.service = service; }

    @PostMapping("/cadastrar")
    public NotaResposta cadastrar(@RequestBody NotaRequisicao req) {
        try { return service.cadastrarNota(req); }
        catch (SQLException e) { throw new RuntimeException(e.getMessage()); }
    }

    @GetMapping("/listar")
    public List<NotaResposta> listar() {
        try { return service.listarNotas(); }
        catch (SQLException e) { throw new RuntimeException(e.getMessage()); }
    }

    @GetMapping("/listar/{id}")
    public NotaResposta buscar(@PathVariable Long id) {
        try { return service.buscarNotaID(id); }
        catch (SQLException e) { throw new RuntimeException(e.getMessage()); }
    }

    @PutMapping("/atualizar/{id}")
    public NotaResposta atualizar(@RequestBody NotaRequisicao req, @PathVariable Long id) {
        try { return service.atualizarNota(req, id); }
        catch (SQLException e) { throw new RuntimeException(e.getMessage()); }
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        try { return service.deletarNota(id); }
        catch (SQLException e) { throw new RuntimeException(e.getMessage()); }
    }
}