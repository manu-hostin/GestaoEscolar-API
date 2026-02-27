package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.conexao.Conexao;
import com.weg.gestaoEscolar.model.Aluno;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;

@Repository
public class AlunoRepo {
    public Aluno cadastroAluno(Aluno aluno) throws SQLException {
        String query = """
            INSERT INTO aluno
            (nome, email, matricula, data_nascimento)
            VALUES
            (?,?,?,?)
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getMatricula());
            stmt.setDate(4, Date.valueOf(aluno.getNascimento()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                aluno.setId(rs.getInt(1));
            }
        }
        return aluno;
    }
}

