package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.DTO.curso.CursoRequisicao;
import com.weg.gestaoEscolar.DTO.curso.CursoResposta;
import com.weg.gestaoEscolar.service.AlunoService;
import com.weg.gestaoEscolar.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping ("/escola/cursos")
public class CursoController {

    private final CursoService service;
    public CursoController (CursoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public CursoResposta cadastrarCurso (@RequestBody CursoRequisicao cursoRequisicao){
        try {
            return service.cadastrarCurso(cursoRequisicao);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<CursoResposta> listarCursos () {
        try {
            return service.listarCursos();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar/{id}")
    public CursoResposta listarCursoID (@PathVariable int id) {
        try {
            return service.listarCursoID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public CursoResposta atualizarCurso (@RequestBody CursoRequisicao cursoRequisicao, @PathVariable int id) {
        try {
            return service.atualizarCurso(cursoRequisicao, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarCurso (@PathVariable int id){
        try {
            return service.deletarCurso(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
