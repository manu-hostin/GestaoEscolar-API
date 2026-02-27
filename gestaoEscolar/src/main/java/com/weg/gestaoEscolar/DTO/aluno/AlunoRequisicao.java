package com.weg.gestaoEscolar.DTO.aluno;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public record AlunoRequisicao (

        int matricula,
        String nome,
        String email,
        LocalDate nascimento

) {}

