package br.com.aporte.controller;

import br.com.aporte.DAO.AtivoDAOImpl;
import br.com.aporte.DAO.GenericDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListarAtivo")
public class ListarAtivo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GenericDAO dao = new AtivoDAOImpl();
            request.setAttribute("ativos", dao.listar());
            request.getRequestDispatcher("listar_ativo.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException("Problemas ao listar Ativos: " + ex.getMessage(), ex);
        }
    }
}