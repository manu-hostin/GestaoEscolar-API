package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.DTO.aula.AulaResposta;
import com.weg.gestaoEscolar.conexao.Conexao;
import com.weg.gestaoEscolar.model.Aula;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class AulaRepo {
    public Aula cadastrarAula(Aula aula) throws SQLException {
        String query = """
            INSERT INTO aula
            (turma_id, data_hora, assunto)
            VALUES
            (?,?,?)
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, aula.getidTurma());
            stmt.setTimestamp(2, Timestamp.valueOf(aula.getDataHora()));
            stmt.setString(3, aula.getAssunto());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                aula.setId(rs.getInt(1));
            }
        }
        return aula;
    }
    public List<Aula> listarAulas() throws SQLException {

        List<Aula> lista = new ArrayList<>();

        String sql = """
                    SELECT a.id, a.turma_id, t.nome AS nome_turma, a.data_hora, a.assunto
                    FROM aula a
                    JOIN turma t ON a.turma_id = t.id
        """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                lista.add(new Aula(
                        rs.getInt("id"),
                        rs.getInt("turma_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("assunto")
                ));
            }
        }

        return lista;
    }

    public Aula buscarPorId(int id) throws SQLException {

        String sql = """
            SELECT a.id, a.turma_id, t.nome AS nome_turma, a.data_hora, a.assunto
            FROM aula a
            JOIN turma t ON a.turma_id = t.id
            WHERE a.id = ?
        """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Aula(
                        rs.getInt("id"),
                        rs.getInt("turma_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("assunto")
                );
            }
        }

        return null;
    }

    public void atualizarAula (Aula aula) throws SQLException {
        String query = """
            UPDATE aula
            SET turma_id = ?, data_hora = ?, assunto = ?
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, aula.getidTurma());
            stmt.setTimestamp(2, Timestamp.valueOf(aula.getDataHora()));
            stmt.setString(3, aula.getAssunto());
            stmt.setInt(4, aula.getId());
            stmt.executeUpdate();

        }
    }

    public String deletarAula(int id) throws SQLException {
        String query = """
            DELETE FROM aula
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0){
                return "Aula deletada do BD com sucesso!";
            }
        }
        return "Aula não encontrado";
    }
}
