package com.weg.gestaoEscolar.controller;

import com.weg.gestaoEscolar.DTO.aluno.AlunoRequisicao;
import com.weg.gestaoEscolar.DTO.aluno.AlunoResposta;
import com.weg.gestaoEscolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/escola/aluno")
public class AlunoController {

   private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
   public AlunoResposta cadastrarAluno (@RequestBody AlunoRequisicao alunoRequisicao){
      try {
         return service.cadastrarUsuario(alunoRequisicao);
      } catch (SQLException e){
         throw new RuntimeException(e.getMessage());
      }
   }

}
