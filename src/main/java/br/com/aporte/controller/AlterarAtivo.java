package br.com.aporte.controller;

import br.com.aporte.DAO.AtivoDAOImpl;
import br.com.aporte.DAO.GenericDAO;
import br.com.aporte.model.Ativo;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AlterarAtivo")
public class AlterarAtivo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Ativo ativo = new Ativo();
            ativo.setIdAtivo(Integer.parseInt(request.getParameter("idAtivo")));
            ativo.setCodigoAtivo(request.getParameter("codigoAtivo"));
            ativo.setNomeEmpresa(request.getParameter("nomeEmpresa"));
            ativo.setTipoInvestimento(request.getParameter("tipoInvestimento"));
            ativo.setQuantidadeCotas(Integer.parseInt(request.getParameter("quantidadeCotas")));
            ativo.setPrecoUnitario(new BigDecimal(request.getParameter("precoUnitario")));

            GenericDAO dao = new AtivoDAOImpl();
            dao.alterar(ativo);
            response.sendRedirect("ListarAtivo");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException("Problemas ao alterar Ativo: " + ex.getMessage(), ex);
        }
    }
}