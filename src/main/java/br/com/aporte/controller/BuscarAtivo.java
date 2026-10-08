package br.com.aporte.controller;

import br.com.aporte.DAO.AtivoDAOImpl;
import br.com.aporte.DAO.GenericDAO;
import br.com.aporte.model.Ativo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BuscarAtivo")
public class BuscarAtivo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idAtivo = Integer.parseInt(request.getParameter("idAtivo"));
            GenericDAO dao = new AtivoDAOImpl();
            Ativo ativo = (Ativo) dao.buscarPorId(idAtivo);

            if (ativo == null) {
                response.sendRedirect("ListarAtivo");
                return;
            }
            request.setAttribute("ativo", ativo);
            request.getRequestDispatcher("alterar_ativo.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException("Problemas ao buscar Ativo: " + ex.getMessage(), ex);
        }
    }
}