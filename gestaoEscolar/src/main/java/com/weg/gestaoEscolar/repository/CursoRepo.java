package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.conexao.Conexao;
import com.weg.gestaoEscolar.model.Curso;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepo {
    public Curso cadastroCurso(Curso curso) throws SQLException {
        String query = """
                INSERT INTO curso
                (nome, codigo)
                VALUES
                (?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                curso.setId(rs.getInt(1));
            }
        }
        return curso;
    }

    public List<Curso> listarCursos() throws SQLException {
        List<Curso> lista = new ArrayList<>();

        String query = """
                SELECT id, nome, codigo
                FROM curso
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")
                ));
            }
        }
        return lista;


    }

    public Curso buscarPorID(int id) throws SQLException {
        String query = """
                SELECT id, nome, codigo
                FROM curso
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Curso(
                        id,
                        rs.getString("nome"),
                        rs.getString("codigo")
                );
            }
        }
        return null;
    }

    public void atualizarCurso(Curso curso) throws SQLException {
        String query = """
                        UPDATE curso
                        SET nome = ?, codigo = ?
                        WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.setInt(3, curso.getId());
            stmt.executeUpdate();

        }
    }

    public String deletarCurso(int id) throws SQLException {
        String query = """
                DELETE FROM curso
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                return "Curso deletado do BD com sucesso!";
            }
        }
        return "Curso não encontrado";
    }
}

