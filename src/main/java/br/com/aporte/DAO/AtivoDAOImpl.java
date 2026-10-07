package br.com.aporte.DAO;

import br.com.aporte.util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
        return false;
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