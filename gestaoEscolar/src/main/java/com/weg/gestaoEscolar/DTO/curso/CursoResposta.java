package com.weg.gestaoEscolar.DTO.curso;

import com.weg.gestaoEscolar.model.Professor;

import java.util.List;

public record CursoResposta (
        int id,
        String nome,
        String codigo,
        List<String> nomesProfessores
){
}
