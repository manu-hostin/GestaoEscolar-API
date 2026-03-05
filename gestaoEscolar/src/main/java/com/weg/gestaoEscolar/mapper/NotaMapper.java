package com.weg.gestaoEscolar.mapper;

import com.weg.gestaoEscolar.DTO.nota.NotaRequisicao;
import com.weg.gestaoEscolar.DTO.nota.NotaResposta;
import com.weg.gestaoEscolar.model.Nota;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotaMapper {

    public Nota paraEntidade(NotaRequisicao req) {
        return new Nota(
                null,
                req.alunoId(),
                req.aulaId(),
                req.valor());
    }

    public NotaResposta paraResposta(Nota nota, String alunoNome, String aulaAssunto) {
        return new NotaResposta(
                nota.getId(),
                alunoNome,
                aulaAssunto,
                nota.getValor()
        );
    }

    public List<NotaResposta> listar(List<Nota> notas, List<String> nomesAlunos, List<String> assuntosAulas) {
        List<NotaResposta> lista = new ArrayList<>();

        for (int i = 0; i < notas.size(); i++) {
            lista.add(paraResposta(notas.get(i), nomesAlunos.get(i), assuntosAulas.get(i)));
        }
        return lista;
    }
}