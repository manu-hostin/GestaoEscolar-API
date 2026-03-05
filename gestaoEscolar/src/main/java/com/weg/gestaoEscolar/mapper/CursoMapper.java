package com.weg.gestaoEscolar.mapper;

import com.weg.gestaoEscolar.DTO.curso.CursoRequisicao;
import com.weg.gestaoEscolar.DTO.curso.CursoResposta;
import com.weg.gestaoEscolar.model.Curso;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CursoMapper {

    public Curso paraEntidade (CursoRequisicao requisicao){
        return new Curso (
                requisicao.nome(),
                requisicao.codigo()
        );
    }
    public CursoResposta paraResposta (Curso curso, List<String> nomes){
        return new CursoResposta(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo(),
                nomes
        );
    }

    public List<CursoResposta> listar(List<Curso> lista) {
        List<CursoResposta> cursos = new ArrayList<>();

        for (Curso curso : lista){
            cursos.add(paraResposta(curso, new ArrayList<>()));
        }
        return cursos;

    }
}
