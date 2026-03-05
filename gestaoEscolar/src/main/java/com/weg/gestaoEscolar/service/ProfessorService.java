package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.professor.ProfessorRequisicao;
import com.weg.gestaoEscolar.DTO.professor.ProfessorResposta;
import com.weg.gestaoEscolar.mapper.ProfessorMapper;
import com.weg.gestaoEscolar.model.Aluno;
import com.weg.gestaoEscolar.model.Professor;
import com.weg.gestaoEscolar.repository.ProfessorRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepo repo;
    private final ProfessorMapper mapper;

    public ProfessorService (ProfessorRepo repo, ProfessorMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ProfessorResposta cadastrarProfessor (ProfessorRequisicao requisicao) throws SQLException {
        Professor prof = mapper.paraEntidade(requisicao);
        return mapper.paraResposta(repo.cadastrarProf(prof));
    }

    public List<ProfessorResposta> listarProfessores() throws SQLException {
        List<Professor> professores = repo.listarProfs();
        return mapper.paraListar(professores);
    }

    public ProfessorResposta listarProfessor(int id) throws SQLException {
        Professor prof = repo.buscarPorID(id);
        return mapper.paraResposta(prof);
    }

    public ProfessorResposta atualizarProf(ProfessorRequisicao requisicao, int id) throws SQLException {
        Professor prof = mapper.paraEntidade(requisicao);
        prof.setId(id);
        repo.atualizarProfessor(prof);
        return mapper.paraResposta(prof);
    }

    public String deletarProfessor(int id) throws SQLException {
        return repo.deletarProfessor(id);
    }
}
