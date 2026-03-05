package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.curso.CursoRequisicao;
import com.weg.gestaoEscolar.DTO.curso.CursoResposta;
import com.weg.gestaoEscolar.mapper.CursoMapper;
import com.weg.gestaoEscolar.model.Curso;
import com.weg.gestaoEscolar.repository.CursoRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepo repo;
    private final CursoMapper mapper;

    public CursoService (CursoRepo repo, CursoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public CursoResposta cadastrarCurso (CursoRequisicao cursoRequisicao) throws SQLException {
        Curso curso = mapper.paraEntidade(cursoRequisicao);
        return mapper.paraResposta(repo.cadastroCurso(curso), List.of());
    }

    public List<CursoResposta> listarCursos() throws SQLException {
        List<Curso> lista = repo.listarCursos();
        return mapper.listar(lista);

    }

    public CursoResposta listarCursoID(int id) throws SQLException {
        Curso curso = repo.buscarPorID(id);
        return mapper.paraResposta(curso, List.of());
    }

    public CursoResposta atualizarCurso(CursoRequisicao requisicao, int id) throws SQLException {
        Curso curso = mapper.paraEntidade(requisicao);
        curso.setId(id);
        repo.atualizarCurso(curso);
        return mapper.paraResposta(curso, List.of());
    }

    public String deletarCurso(int id) throws SQLException {
        return repo.deletarCurso(id);
    }
}
