package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.mapper.AlunoMapper;
import com.weg.gestaoEscolar.model.Aluno;
import com.weg.gestaoEscolar.repository.AlunoRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepo repo;
    private final AlunoMapper mapper;

    public AlunoService (AlunoRepo repo, AlunoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public AlunoResposta cadastrarUsuario (AlunoRequisicao alunoRequisicao) throws SQLException {
        Aluno aluno = mapper.paraEntidade(alunoRequisicao);
        return mapper.paraResposta(repo.cadastroAluno(aluno));
    }

    public List<AlunoResposta> listarAlunos() throws SQLException {
        List<Aluno> lista = repo.listarAlunos();
        return mapper.listar(lista);

    }

    public AlunoResposta listarAlunoID(int id) throws SQLException {
        Aluno aluno = repo.buscarPorID(id);
        return mapper.paraResposta(aluno);
    }

    public AlunoResposta atualizarAluno(AlunoRequisicao requisicao, int id) throws SQLException {
        Aluno aluno = mapper.paraEntidade(requisicao);
        aluno.setId(id);
        repo.atualizarAluno(aluno);
        return mapper.paraResposta(aluno);
    }

    public String deletarAluno(int id) throws SQLException {
        return repo.deletarAluno(id);
    }
}
