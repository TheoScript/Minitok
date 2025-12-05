package dao;

import model.Usuario;
import util.ConexaoBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    // salvar
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha, data_cadastro) VALUES (?, ?, ?)";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConexaoBD.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fechar(con, stmt, null);
        }
    }

    // aqui é pra atualizar
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConexaoBD.getConnection();
            stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fechar(con, stmt, null);
        }
    }

    // adivinha o que a função chamada deletar faz?
    public void deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = ConexaoBD.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fechar(con, stmt, null);
        }
    }

    // me recuso a dizer
    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Usuario usuario = null;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConexaoBD.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fechar(con, stmt, rs);
        }

        return usuario;
    }

    // ...
    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM usuarios";

        List<Usuario> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConexaoBD.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fechar(con, stmt, rs);
        }

        return lista;
    }
}
