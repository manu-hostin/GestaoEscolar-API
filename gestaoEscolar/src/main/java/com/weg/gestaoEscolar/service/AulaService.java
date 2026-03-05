package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.DTO.aula.AulaRequisicao;
import com.weg.gestaoEscolar.DTO.aula.AulaResposta;
import com.weg.gestaoEscolar.mapper.AlunoMapper;
import com.weg.gestaoEscolar.mapper.AulaMapper;
import com.weg.gestaoEscolar.model.Aluno;
import com.weg.gestaoEscolar.model.Aula;
import com.weg.gestaoEscolar.repository.AlunoRepo;
import com.weg.gestaoEscolar.repository.AulaRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AulaService {

    private final AulaRepo repo;
    private final AulaMapper mapper;

    public AulaService (AulaRepo repo, AulaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public AulaResposta cadastrarAula(AulaRequisicao requisicao) throws SQLException {

        Aula aula = mapper.paraEntidade(requisicao);
        Aula aulaSalva = repo.cadastrarAula(aula);

        return mapper.paraResposta(aulaSalva, "");
    }

    public List<AulaResposta> listarAulas() throws SQLException {
        List<Aula> lista = repo.listarAulas();
        return mapper.listar(lista);

    }

    public AulaResposta listarAulaID(int id) throws SQLException {

        Aula aula = repo.buscarPorId(id);

        return mapper.paraResposta(aula, "");
    }

    public AulaResposta atualizarAula(AulaRequisicao requisicao, int id) throws SQLException {
        Aula aula = mapper.paraEntidade(requisicao);
        aula.setId(id);
        repo.atualizarAula(aula);
        return mapper.paraResposta(aula, "");
    }

    public String deletarAula(int id) throws SQLException {
        return repo.deletarAula(id);
    }
}