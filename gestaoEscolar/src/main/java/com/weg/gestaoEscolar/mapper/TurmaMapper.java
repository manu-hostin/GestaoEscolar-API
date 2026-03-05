package com.weg.gestaoEscolar.mapper;

import com.weg.gestaoEscolar.DTO.turma.TurmaRequisicao;
import com.weg.gestaoEscolar.DTO.turma.TurmaResposta;
import com.weg.gestaoEscolar.model.Turma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurmaMapper {

    public Turma paraEntidade(TurmaRequisicao req){

        return new Turma(
                req.nome(),
                req.cursoId(),
                req.professorId()
        );

    }

    public TurmaResposta paraResposta(
            Turma turma,
            String nomeCurso,
            String nomeProfessor,
            List<String> alunos
    ){

        return new TurmaResposta(
                turma.getId(),
                turma.getNome(),
                nomeCurso,
                nomeProfessor,
                alunos
        );

    }
}