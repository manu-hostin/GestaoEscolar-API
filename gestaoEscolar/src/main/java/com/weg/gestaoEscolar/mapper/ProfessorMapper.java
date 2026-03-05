package com.weg.gestaoEscolar.mapper;

import com.weg.gestaoEscolar.DTO.professor.ProfessorRequisicao;
import com.weg.gestaoEscolar.DTO.professor.ProfessorResposta;
import com.weg.gestaoEscolar.model.Professor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorMapper {

    public Professor paraEntidade (ProfessorRequisicao requisicao) {
        return new Professor(
                requisicao.nome(),
                requisicao.disciplina(),
                requisicao.email()
        );
    }
    public ProfessorResposta paraResposta (Professor prof){
        return new ProfessorResposta(
                prof.getId(),
                prof.getNome(),
                prof.getEmail(),
                prof.getDisciplina()
        );
    }

    public List<ProfessorResposta> paraListar (List<Professor> lista) {
        List<ProfessorResposta> professorRespostas = new ArrayList<>();

        for (Professor prof : lista){
            professorRespostas.add(paraResposta(prof));
        }
        return professorRespostas;
    }

}
