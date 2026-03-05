package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.model.Nota;
import com.weg.gestaoEscolar.conexao.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotaRepo {

    public Nota cadastrarNota(Nota nota) throws SQLException {
        String sql = "INSERT INTO nota (aluno_id, aula_id, valor) VALUES (?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, nota.getAlunoId());
            ps.setLong(2, nota.getAulaId());
            ps.setDouble(3, nota.getValor());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                nota.setId(rs.getLong(1));
            }
        }
        return nota;
    }

    public List<Nota> listarNotas() throws SQLException {
        List<Nota> lista = new ArrayList<>();
        String sql = "SELECT id, aluno_id, aula_id, valor FROM nota";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Nota(
                        rs.getLong("id"),
                        rs.getLong("aluno_id"),
                        rs.getLong("aula_id"),
                        rs.getDouble("valor")
                ));
            }
        }
        return lista;
    }

    public Nota buscarPorID(Long id) throws SQLException {
        String sql = "SELECT * FROM nota WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Nota(
                        rs.getLong("id"),
                        rs.getLong("aluno_id"),
                        rs.getLong("aula_id"),
                        rs.getDouble("valor")
                );
            }
        }
        return null;
    }

    public void atualizarNota(Nota nota) throws SQLException {
        String sql = "UPDATE nota SET aluno_id = ?, aula_id = ?, valor = ? WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, nota.getAlunoId());
            ps.setLong(2, nota.getAulaId());
            ps.setDouble(3, nota.getValor());
            ps.setLong(4, nota.getId());
            ps.executeUpdate();
        }
    }

    public String deletarNota(Long id) throws SQLException {
        String sql = "DELETE FROM nota WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            int linhas = ps.executeUpdate();
            if (linhas > 0) return "Nota deletada com sucesso!";
        }
        return "Nota não encontrada";
    }

    public String buscarNomeAluno(Long alunoId) throws SQLException {
        String sql = "SELECT nome FROM aluno WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, alunoId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("nome");
        }
        return "";
    }

    public String buscarAssuntoAula(Long aulaId) throws SQLException {
        String sql = "SELECT assunto FROM aula WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, aulaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("assunto");
        }
        return "";
    }
}