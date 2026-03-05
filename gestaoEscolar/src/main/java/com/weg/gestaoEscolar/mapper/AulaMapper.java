package com.weg.gestaoEscolar.mapper;

import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.DTO.aula.AulaRequisicao;
import com.weg.gestaoEscolar.DTO.aula.AulaResposta;
import com.weg.gestaoEscolar.model.Aluno;
import com.weg.gestaoEscolar.model.Aula;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AulaMapper {

    public Aula paraEntidade (AulaRequisicao requisicao) {
        return new Aula (
                requisicao.turmaID(),
                requisicao.dataHora(),
                requisicao.assunto()
        );
    }

    public AulaResposta paraResposta(Aula aula, String nomeTurma){
        return new AulaResposta(
                aula.getId(),
                nomeTurma,
                aula.getDataHora(),
                aula.getAssunto()
        );
    }

    public List<AulaResposta> listar (List<Aula> lista) {
        List<AulaResposta> aulas = new ArrayList<>();

        for (Aula aula : lista){
            aulas.add(paraResposta(aula, ""));
        }
        return aulas;
    }
}
