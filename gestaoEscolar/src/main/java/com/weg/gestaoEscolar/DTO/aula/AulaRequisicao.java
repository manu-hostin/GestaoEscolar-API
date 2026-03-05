package com.weg.gestaoEscolar.DTO.aula;

import java.time.LocalDateTime;

public record AulaRequisicao (
         int turmaID,
         LocalDateTime dataHora,
         String assunto
){ }
