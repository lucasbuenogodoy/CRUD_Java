<%@page import="java.util.List"%>
<%@page import="br.com.aporte.model.Ativo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ativos</title>
    </head>
    <body>
        <h1>Lista de Ativos</h1>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Cotas</th>
                    <th>Preço unitário</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Ativo> ativos = (List<Ativo>) request.getAttribute("ativos");
                    for (Ativo ativo : ativos) {
                %>
                <tr>
                    <td><%= ativo.getIdAtivo() %></td>
                    <td><%= ativo.getCodigoAtivo() %></td>
                    <td><%= ativo.getNomeEmpresa() %></td>
                    <td><%= ativo.getTipoInvestimento() %></td>
                    <td><%= ativo.getQuantidadeCotas() %></td>
                    <td><%= ativo.getPrecoUnitario() %></td>
                    <td><a href="BuscarAtivo?idAtivo=<%= ativo.getIdAtivo() %>">Editar</a></td>
                    <td><a href="ExcluirAtivo?idAtivo=<%= ativo.getIdAtivo() %>"
                           onclick="return confirm('Excluir este ativo?')">Excluir</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <a href="index.jsp">Voltar</a>
    </body>
</html>