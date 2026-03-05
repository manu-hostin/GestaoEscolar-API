package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.turma.TurmaRequisicao;
import com.weg.gestaoEscolar.DTO.turma.TurmaResposta;
import com.weg.gestaoEscolar.mapper.TurmaMapper;
import com.weg.gestaoEscolar.model.Turma;
import com.weg.gestaoEscolar.repository.TurmaRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepo turmaRepository;

    public TurmaService(TurmaRepo turmaRepository){
        this.turmaRepository = turmaRepository;
    }

    public Turma cadastrar(Turma turma) throws SQLException {
        return turmaRepository.cadastrarTurma(turma);
    }

    public List<Turma> listar() throws SQLException {
        return turmaRepository.listarTurmas();
    }

    public Turma atualizar(Long id, Turma turma) throws SQLException {
        turma.setId(id.intValue());
        turmaRepository.atualizarTurma(turma);
        return turma;
    }

    public String deletar(Long id) throws SQLException {
        return turmaRepository.deletarTurma(id.intValue());
    }
}