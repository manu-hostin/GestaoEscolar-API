package com.weg.gestaoEscolar.DTO.turma;

import java.util.List;

public record TurmaRequisicao (

        String nome,
        int cursoId,
        int professorId,
        List<Integer> listaAlunoIds
) {
}
