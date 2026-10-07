package br.com.aporte.DAO;

import br.com.aporte.util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import br.com.aporte.model.Ativo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AtivoDAOImpl implements GenericDAO {

    private Connection conn;

    public AtivoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Ativo ativo = (Ativo) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO ativo (codigo_ativo, nome_empresa, tipo_investimento, "
                + "quantidade_cotas, preco_unitario) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ativo.getCodigoAtivo());
            stmt.setString(2, ativo.getNomeEmpresa());
            stmt.setString(3, ativo.getTipoInvestimento());
            stmt.setInt(4, ativo.getQuantidadeCotas());
            stmt.setBigDecimal(5, ativo.getPrecoUnitario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Ativo! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ativo ORDER BY id_ativo";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ativo ativo = new Ativo();
                ativo.setIdAtivo(rs.getInt("id_ativo"));
                ativo.setCodigoAtivo(rs.getString("codigo_ativo"));
                ativo.setNomeEmpresa(rs.getString("nome_empresa"));
                ativo.setTipoInvestimento(rs.getString("tipo_investimento"));
                ativo.setQuantidadeCotas(rs.getInt("quantidade_cotas"));
                ativo.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                resultado.add(ativo);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Ativos! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public Boolean alterar(Object object) {
        Ativo ativo = (Ativo) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE ativo SET codigo_ativo = ?, nome_empresa = ?, tipo_investimento = ?, "
                + "quantidade_cotas = ?, preco_unitario = ? WHERE id_ativo = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ativo.getCodigoAtivo());
            stmt.setString(2, ativo.getNomeEmpresa());
            stmt.setString(3, ativo.getTipoInvestimento());
            stmt.setInt(4, ativo.getQuantidadeCotas());
            stmt.setBigDecimal(5, ativo.getPrecoUnitario());
            stmt.setInt(6, ativo.getIdAtivo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Ativo! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM ativo WHERE id_ativo = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Ativo! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object buscarPorId(int idObject) {
        Ativo ativo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ativo WHERE id_ativo = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                ativo = new Ativo();
                ativo.setIdAtivo(rs.getInt("id_ativo"));
                ativo.setCodigoAtivo(rs.getString("codigo_ativo"));
                ativo.setNomeEmpresa(rs.getString("nome_empresa"));
                ativo.setTipoInvestimento(rs.getString("tipo_investimento"));
                ativo.setQuantidadeCotas(rs.getInt("quantidade_cotas"));
                ativo.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao buscar Ativo! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return ativo;
    }
}