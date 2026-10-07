package br.com.aporte.DAO;

import br.com.aporte.util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import br.com.aporte.model.Ativo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        return new ArrayList<>();
    }

    @Override
    public Boolean alterar(Object object) {
        return false;
    }

    @Override
    public void excluir(int idObject) {
    }

    @Override
    public Object buscarPorId(int idObject) {
        return null;
    }
}