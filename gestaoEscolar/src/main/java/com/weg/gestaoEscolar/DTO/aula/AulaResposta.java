package com.weg.gestaoEscolar.DTO.aula;

import java.time.LocalDateTime;

public record AulaResposta (
    int id,
    String nomeTurma,
    LocalDateTime dataHota,
    String assunto

) {}
