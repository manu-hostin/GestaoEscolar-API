package com.weg.gestaoEscolar.service;

import com.weg.gestaoEscolar.DTO.nota.NotaRequisicao;
import com.weg.gestaoEscolar.DTO.nota.NotaResposta;
import com.weg.gestaoEscolar.mapper.NotaMapper;
import com.weg.gestaoEscolar.model.Nota;
import com.weg.gestaoEscolar.repository.NotaRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepo repo;
    private final NotaMapper mapper;

    public NotaService(NotaRepo repo, NotaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public NotaResposta cadastrarNota(NotaRequisicao req) throws SQLException {
        Nota nota = mapper.paraEntidade(req);

        Nota notaCadastrada = repo.cadastrarNota(nota);

        String alunoNome = repo.buscarNomeAluno(notaCadastrada.getAlunoId());
        String aulaAssunto = repo.buscarAssuntoAula(notaCadastrada.getAulaId());

        return mapper.paraResposta(notaCadastrada, alunoNome, aulaAssunto);
    }

    public List<NotaResposta> listarNotas() throws SQLException {
        List<Nota> notas = repo.listarNotas();
        List<NotaResposta> lista = new ArrayList<>();

        for (Nota n : notas) {
            String alunoNome = repo.buscarNomeAluno(n.getAlunoId());
            String aulaAssunto = repo.buscarAssuntoAula(n.getAulaId());
            lista.add(mapper.paraResposta(n, alunoNome, aulaAssunto));
        }
        return lista;
    }

    public NotaResposta buscarNotaID(Long id) throws SQLException {
        Nota nota = repo.buscarPorID(id);

        // Buscar nomes usando os IDs
        String alunoNome = repo.buscarNomeAluno(nota.getAlunoId());
        String aulaAssunto = repo.buscarAssuntoAula(nota.getAulaId());

        return mapper.paraResposta(nota, alunoNome, aulaAssunto);
    }

    public NotaResposta atualizarNota(NotaRequisicao req, Long id) throws SQLException {
        Nota notaAtualizada  = mapper.paraEntidade(req);
        notaAtualizada .setId(id);

        repo.atualizarNota(notaAtualizada);
        String alunoNome = repo.buscarNomeAluno(notaAtualizada.getAlunoId());
        String aulaAssunto = repo.buscarAssuntoAula(notaAtualizada.getAulaId());

        return mapper.paraResposta(notaAtualizada, alunoNome, aulaAssunto);

    }

    public String deletarNota(Long id) throws SQLException {
        return repo.deletarNota(id);
    }
}