package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.mapper.AlunoMapper;
import com.weg.gestaoEscolar.model.Aluno;
import com.weg.gestaoEscolar.repository.AlunoRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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
}
