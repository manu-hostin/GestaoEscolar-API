package com.weg.gestaoEscolar.DTO.turma;

import java.util.List;

public record TurmaResposta(

        int id,
        String nome,
        String nomeCurso,
        String nomeProfessor,
        List<String> listaAlunos

) {}
