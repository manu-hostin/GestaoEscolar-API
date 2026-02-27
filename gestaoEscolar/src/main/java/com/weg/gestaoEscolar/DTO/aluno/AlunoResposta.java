package com.weg.gestaoEscolar.DTO.aluno;

import java.time.LocalDate;
import java.util.Date;

public record AlunoResposta (
        int id,
        int matricula,
        String nome,
        String email,
        LocalDate nascimento
) {}
