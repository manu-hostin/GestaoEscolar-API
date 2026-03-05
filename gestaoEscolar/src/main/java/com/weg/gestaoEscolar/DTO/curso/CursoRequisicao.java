package com.weg.gestaoEscolar.DTO.curso;

import com.weg.gestaoEscolar.model.Professor;

import java.util.List;

public record CursoRequisicao (

        String nome,
        String codigo,
        List<Integer> professoresIDS
){
}
