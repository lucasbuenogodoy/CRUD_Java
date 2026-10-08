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

@WebServlet("/CadastrarAtivo")
public class CadastrarAtivo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            Ativo ativo = new Ativo();
            ativo.setCodigoAtivo(request.getParameter("codigoAtivo"));
            ativo.setNomeEmpresa(request.getParameter("nomeEmpresa"));
            ativo.setTipoInvestimento(request.getParameter("tipoInvestimento"));
            ativo.setQuantidadeCotas(Integer.parseInt(request.getParameter("quantidadeCotas")));
            ativo.setPrecoUnitario(new BigDecimal(request.getParameter("precoUnitario")));

            GenericDAO dao = new AtivoDAOImpl();
            if (dao.cadastrar(ativo)) {
                mensagem = "Ativo cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Ativo!";
            }
        } catch (Exception ex) {
            mensagem = "Problemas ao cadastrar Ativo! Erro: " + ex.getMessage();
            ex.printStackTrace();
        }
        request.setAttribute("sucesso", mensagem);
        request.getRequestDispatcher("cadastrar_ativo.jsp").forward(request, response);
    }
}