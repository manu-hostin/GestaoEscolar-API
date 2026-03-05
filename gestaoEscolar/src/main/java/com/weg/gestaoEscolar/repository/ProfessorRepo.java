package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.conexao.Conexao;
import com.weg.gestaoEscolar.model.Professor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepo {
    public Professor cadastrarProf(Professor prof) throws SQLException {
        String query = """
            INSERT INTO professor
            (nome, email, disciplina)
            VALUES
            (?,?,?)
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getEmail());
            stmt.setString(3, prof.getDisciplina());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                prof.setId(rs.getInt(1));
            }
        }
        return prof;
    }

    public List<Professor> listarProfs() throws SQLException {
        List<Professor> lista = new ArrayList<>();

        String query = """
                SELECT id, nome, email, disciplina
                FROM professor
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("disciplina")
                ));
            }
        }
        return lista;
    }

    public Professor buscarPorID (int id) throws SQLException {
        String query = """
            SELECT id, nome, email, disciplina
            FROM professor
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Professor(
                        id,
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("disciplina")
                );
            }
        }
        return null;
    }

    public void atualizarProfessor(Professor prof) throws SQLException {
        String query = """
            UPDATE professor
            SET nome = ?, email = ?, disciplina = ?
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getEmail());
            stmt.setString(3, prof.getDisciplina());
            stmt.setInt(4, prof.getId());
            stmt.executeUpdate();

        }
    }

    public String deletarProfessor (int id) throws SQLException {
        String query = """
            DELETE FROM professor
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                return "Professor deletado do BD com sucesso!";
            }
        }
        return "Professor não encontrado";

    }
}
