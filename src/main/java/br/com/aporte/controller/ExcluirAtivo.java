package br.com.aporte.controller;

import br.com.aporte.DAO.AtivoDAOImpl;
import br.com.aporte.DAO.GenericDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirAtivo")
public class ExcluirAtivo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idAtivo = Integer.parseInt(request.getParameter("idAtivo"));
            GenericDAO dao = new AtivoDAOImpl();
            dao.excluir(idAtivo);
            response.sendRedirect("ListarAtivo");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException("Problemas ao excluir Ativo: " + ex.getMessage(), ex);
        }
    }
}