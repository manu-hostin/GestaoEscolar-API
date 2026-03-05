package com.weg.gestaoEscolar.repository;

import com.weg.gestaoEscolar.conexao.Conexao;
import com.weg.gestaoEscolar.model.Turma;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepo {

    public Turma cadastrarTurma(Turma turma) throws SQLException {

        String query = """
        INSERT INTO turma
        (nome, curso_id, professor_id)
        VALUES (?,?,?)
        """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCursoId());
            stmt.setInt(3, turma.getProfessorId());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                turma.setId(rs.getInt(1));
            }

        }

        return turma;
    }

    public List<Turma> listarTurmas() throws SQLException {

        List<Turma> lista = new ArrayList<>();

        String query = """
        SELECT id, nome, curso_id, professor_id
        FROM turma
        """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("professor_id")
                ));
            }
        }

        return lista;
    }

    public Turma buscarPorId(int id) throws SQLException {

        String query = """
        SELECT id, nome, curso_id, professor_id
        FROM turma
        WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("curso_id"),
                        rs.getInt("professor_id")
                );
            }
        }

        return null;
    }

    public void atualizarTurma(Turma turma) throws SQLException {

        String query = """
        UPDATE turma
        SET nome = ?, curso_id = ?, professor_id = ?
        WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCursoId());
            stmt.setInt(3, turma.getProfessorId());
            stmt.setInt(4, turma.getId());

            stmt.executeUpdate();
        }
    }

    public String deletarTurma(int id) throws SQLException {

        String query = """
        DELETE FROM turma
        WHERE id = ?
        """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if(linhas > 0){
                return "Turma deletada com sucesso!";
            }
        }

        return "Turma não encontrada";
    }

}