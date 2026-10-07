package br.com.aporte.DAO;

import java.util.List;

public interface GenericDAO {

    Boolean cadastrar(Object object);

    List<Object> listar();

    Boolean alterar(Object object);

    void excluir(int idObject);

    Object buscarPorId(int idObject);
}