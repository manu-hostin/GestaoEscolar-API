package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.conexao.Conexao;
import com.weg.gestaoEscolar.model.Aluno;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Aluno> listarAlunos() throws SQLException {
        List<Aluno> lista = new ArrayList<>();

        String query = """
                SELECT id, nome, email, matricula, data_nascimento
                FROM aluno
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Aluno(
                        rs.getInt("id"),
                        rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate()
                ));
            }
        }
        return lista;


    }

    public Aluno buscarPorID(int id) throws SQLException {
        String query = """
            SELECT id, matricula, nome, email, data_nascimento
            FROM aluno
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Aluno(
                        id,
                        rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate()
                );
            }
        }
        return null;
    }

    public void atualizarAluno (Aluno aluno) throws SQLException {
        String query = """
            UPDATE aluno
            SET matricula = ?, nome = ?, email = ?, data_nascimento = ?
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getNascimento()));
            stmt.setInt(5, aluno.getId());
            stmt.executeUpdate();

        }
    }

    public String deletarAluno(int id) throws SQLException {
        String query = """
            DELETE FROM aluno
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                return "Aluno deletado do BD com sucesso!";
            }
        }
        return "Aluno não encontrado";
    }
}